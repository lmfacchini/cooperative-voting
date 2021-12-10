package com.cooperative.voting.bridge.service;

import com.cooperative.voting.bridge.to.VoteSessionTO;

public interface VoteSessionService {


    VoteSessionTO create(VoteSessionTO voteSession);

    VoteSessionTO findBySession(String session);

    VoteSessionTO update(VoteSessionTO voteSession);
}
