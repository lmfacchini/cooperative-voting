package com.cooperative.voting.core.service;

import com.cooperative.voting.bridge.BusinessException;
import com.cooperative.voting.bridge.service.VoteSessionService;
import com.cooperative.voting.bridge.to.VoteSessionTO;
import com.cooperative.voting.core.repository.VoteSessionRepository;
import com.cooperative.voting.domain.VoteSessionVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VoteSessionServiceImpl implements VoteSessionService {

    private final VoteSessionRepository voteSessionRepository;

    @Override
    public VoteSessionTO create(VoteSessionTO to) {
        VoteSessionVO vo = voteSessionRepository.findBySession(to.getSession());
        if(vo != null){

            throw new BusinessException("B000004");
        }
        vo = parse(to);
        vo = voteSessionRepository.save(vo);
        return parse(vo);
    }

    @Override
    public VoteSessionTO findBySession(String session) {
        VoteSessionVO vo = voteSessionRepository.findBySession(session);
        if(vo == null){
            return null;
        }
        return parse(vo);
    }

    @Override
    public VoteSessionTO update(VoteSessionTO voteSession) {
        VoteSessionVO vo = voteSessionRepository.findBySession(voteSession.getSession());
        if(vo == null){
            throw new BusinessException("B000006");
        }
        vo.setVotes(voteSession.getVotes());
        voteSessionRepository.save(vo);
        return voteSession;
    }


    private VoteSessionTO parse(VoteSessionVO vo){
        VoteSessionTO to = new VoteSessionTO();
        to.setExpires(vo.getExpires());
        to.setSession(vo.getSession());
        to.setTimeUnit(vo.getTimeUnit());
        to.setQuestion(vo.getQuestion());
        to.setVotes(vo.getVotes());
        to.setDatetime(vo.getDatetime());

        return to;
    }

    private VoteSessionVO parse(VoteSessionTO to){
        VoteSessionVO vo = new VoteSessionVO();
        vo.setExpires(to.getExpires());
        vo.setSession(to.getSession());
        vo.setTimeUnit(to.getTimeUnit());
        vo.setQuestion(to.getQuestion());
        vo.setVotes(to.getVotes());
        vo.setDatetime(to.getDatetime());

        return vo;
    }
}
