package com.cooperative.voting.ws.controller;

import com.cooperative.voting.bridge.controller.VotingController;
import com.cooperative.voting.bridge.service.VotingService;
import com.cooperative.voting.bridge.to.VoteCountTO;
import com.cooperative.voting.bridge.to.VoteTO;
import com.cooperative.voting.bridge.to.VotingOpenedSessionTO;
import com.cooperative.voting.bridge.to.VotingOpenenSessionTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class VotingControllerImpl implements VotingController {


    private final VotingService votingService;



    @Override
    public ResponseEntity<VotingOpenedSessionTO> openSession(VotingOpenenSessionTO votingOpenenSession) {
        return ResponseEntity.ok(votingService.openSession(votingOpenenSession));
    }

    @Override
    public ResponseEntity<VoteTO> vote(VoteTO vote) {
        return ResponseEntity.ok(votingService.vote(vote));
    }

    @Override
    public ResponseEntity<VoteCountTO> votes(String session) {
        VoteCountTO result = votingService.countVotes(session);
        if(result == null){
            ResponseEntity.noContent();
        }
        return ResponseEntity.ok(result);
    }
}
