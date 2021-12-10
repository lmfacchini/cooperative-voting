package com.cooperative.voting.core.service;

import com.cooperative.voting.bridge.BusinessException;
import com.cooperative.voting.bridge.service.QuestionService;
import com.cooperative.voting.bridge.to.QuestionTO;
import com.cooperative.voting.core.repository.QuestionRepository;
import com.cooperative.voting.domain.QuestionVO;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public QuestionTO create(QuestionTO to) {
        QuestionVO vo = questionRepository.findByName(to.getName());
        if(vo != null){
            throw new BusinessException("B000005");
        }

        vo = parse(to);
        vo = questionRepository.save(vo);


        return parse(vo);
    }

    @Override
    public QuestionTO findByIdHex(String IdHex) {
        ObjectId id = new ObjectId(IdHex);
        Optional<QuestionVO> optional = questionRepository.findById(id);

        if(!optional.isPresent()){
            return null;
        }

        return parse(optional.get());
    }


    private QuestionTO parse(QuestionVO vo){
        QuestionTO to = new QuestionTO();
        to.setName(vo.getName());
        to.setId(vo.getId().toHexString());
        to.setDescription(vo.getDescription());
        return to;
    }

    private QuestionVO parse(QuestionTO to){
        QuestionVO vo = new QuestionVO();
        vo.setName(to.getName());
        vo.setDescription(to.getDescription());

        return vo;
    }
}
