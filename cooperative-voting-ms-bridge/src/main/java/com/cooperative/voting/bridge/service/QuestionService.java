package com.cooperative.voting.bridge.service;

import com.cooperative.voting.bridge.to.QuestionTO;

public interface QuestionService {

    QuestionTO create(QuestionTO votingAgenda);


    QuestionTO findByIdHex(String IdHex);
}
