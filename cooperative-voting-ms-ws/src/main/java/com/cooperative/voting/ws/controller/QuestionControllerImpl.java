package com.cooperative.voting.ws.controller;

import com.cooperative.voting.bridge.controller.QuestionController;
import com.cooperative.voting.bridge.service.QuestionService;
import com.cooperative.voting.bridge.to.QuestionTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class QuestionControllerImpl implements QuestionController {


    private final QuestionService questionService;


    @Override
    public ResponseEntity<QuestionTO> newQuestion(QuestionTO question) {
        return ResponseEntity.ok(questionService.create(question));
    }

    @Override
    public ResponseEntity<QuestionTO> getQuestion(String questionId) {
        return ResponseEntity.ok(questionService.findByIdHex(questionId));
    }
}
