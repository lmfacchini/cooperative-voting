package com.cooperative.voting.bridge.controller;

import com.cooperative.voting.bridge.to.QuestionTO;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/question")
public interface QuestionController {

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Body created question."),
            @ApiResponse(code = 400, message = "Business error or parameter invalids"),
            @ApiResponse(code = 500, message = "Exception"),
    })
    @PostMapping
    ResponseEntity<QuestionTO> newQuestion(@RequestBody QuestionTO question);


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Body created question."),
            @ApiResponse(code = 204, message = "Question not found."),
            @ApiResponse(code = 400, message = "Business error or parameter invalids"),
            @ApiResponse(code = 500, message = "Exception"),
    })
    @GetMapping
    ResponseEntity<QuestionTO> getQuestion(@ApiParam(name = "question", required = true) @RequestParam("question")  String questionId);

}
