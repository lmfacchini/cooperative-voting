package com.cooperative.voting.bridge.controller;

import com.cooperative.voting.bridge.to.VoteCountTO;
import com.cooperative.voting.bridge.to.VoteTO;
import com.cooperative.voting.bridge.to.VotingOpenedSessionTO;
import com.cooperative.voting.bridge.to.VotingOpenenSessionTO;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/voting")
public interface VotingController {


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Session created."),
            @ApiResponse(code = 400, message = "Business error or parameter invalids"),
            @ApiResponse(code = 500, message = "Exception"),
    })
    @PostMapping("/openSession")
    ResponseEntity<VotingOpenedSessionTO> openSession(@RequestBody VotingOpenenSessionTO votingOpenenSession);

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success voted."),
            @ApiResponse(code = 400, message = "Business error or parameter invalids"),
            @ApiResponse(code = 500, message = "Exception"),
    })
    @PostMapping("/vote")
    ResponseEntity<VoteTO> vote(@RequestBody VoteTO vote);


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Body created question."),
            @ApiResponse(code = 204, message = "Question not found."),
            @ApiResponse(code = 400, message = "Business error or parameter invalids"),
            @ApiResponse(code = 500, message = "Exception"),
    })
    @GetMapping("/votes")
    ResponseEntity<VoteCountTO> votes(@RequestParam("session") String session);


}
