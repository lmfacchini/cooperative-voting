package com.cooperative.voting.core.service;

import com.cooperative.voting.bridge.BusinessException;
import com.cooperative.voting.bridge.ServiceException;
import com.cooperative.voting.bridge.service.VoteSessionService;
import com.cooperative.voting.bridge.service.VotingService;
import com.cooperative.voting.bridge.to.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class VotingServiceImpl implements VotingService {


    private final StringRedisTemplate redisTemplate;


    private final VoteSessionService voteSessionService;


    @Override
    public VotingOpenedSessionTO openSession(VotingOpenenSessionTO votingOpenenSession) {

        try{
            LocalDateTime datetime = LocalDateTime.now();
            String session = DateFormatUtils.format(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()), "YYYYMMddHmm");
            ValueOperations<String, String> oper = redisTemplate.opsForValue();

            ObjectMapper om = new ObjectMapper();
            StringWriter writer = new StringWriter();
            VotingInProgressTO vp = new VotingInProgressTO();
            vp.setQuestion(votingOpenenSession.getQuestion());
            om.writeValue(writer, vp);
            oper.set(session, writer.toString(), votingOpenenSession.getExpires(), votingOpenenSession.getTimeUnit());

            VoteSessionTO voteSession = new VoteSessionTO();

            voteSession.setExpires(votingOpenenSession.getExpires());
            voteSession.setQuestion(votingOpenenSession.getQuestion());
            voteSession.setTimeUnit(votingOpenenSession.getTimeUnit());
            voteSession.setDatetime(datetime);
            voteSession.setSession(session);
            voteSession = voteSessionService.create(voteSession);
            return new VotingOpenedSessionTO(voteSession.getSession());
        }catch (BusinessException ex){
            throw ex;
        }catch (Exception ex){
            throw new ServiceException(ex);
        }


    }


    @Override
    public VoteTO vote(VoteTO vote) {
        try{
            ValueOperations<String, String> oper = redisTemplate.opsForValue();
            String vpStr = oper.get(vote.getSession());
            if(StringUtils.isBlank(vpStr)){
                throw new BusinessException("B000001");
            }
            ObjectMapper om = new ObjectMapper();
            VotingInProgressTO vp = om.readValue(vpStr, VotingInProgressTO.class);
            if(vp.getAssociates().contains(vote.getAssociate())){
                throw new BusinessException("B000002");
            }
            vp.getAssociates().add(vote.getAssociate());

            long expires = redisTemplate.getExpire(vote.getSession(), TimeUnit.SECONDS);
            redisTemplate.delete(vote.getSession());

            StringWriter writer = new StringWriter();
            om.writeValue(writer, vp);
            oper.set(vote.getSession(), writer.toString(), expires, TimeUnit.SECONDS);
            VoteSessionTO voteSession = voteSessionService.findBySession(vote.getSession());

            Integer count = voteSession.getVotes().get(vote.getValue());
            if(count == null){
                count = 1;
            }else{
                count += 1;
            }
            voteSession.getVotes().put(vote.getValue(), count);
            voteSessionService.update(voteSession);
            return vote;
        }catch (BusinessException ex){
            throw ex;
        }catch (Exception ex){
            throw new ServiceException(ex);
        }

    }

    @Override
    public VoteCountTO countVotes(String session) {
        VoteSessionTO voteSession = voteSessionService.findBySession(session);
        if(voteSession == null){
            return null;
        }
        return new VoteCountTO(voteSession.getQuestion(), voteSession.getSession(), voteSession.getVotes());
    }
}
