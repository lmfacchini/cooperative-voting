package com.cooperative.voting.bridge.service;

import com.cooperative.voting.bridge.to.VoteCountTO;
import com.cooperative.voting.bridge.to.VoteTO;
import com.cooperative.voting.bridge.to.VotingOpenedSessionTO;
import com.cooperative.voting.bridge.to.VotingOpenenSessionTO;

import java.util.Collection;

public interface VotingService {
    VotingOpenedSessionTO openSession(VotingOpenenSessionTO votingOpenenSession);

    VoteTO vote(VoteTO vote);

    VoteCountTO countVotes(String session);
}
