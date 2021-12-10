package com.cooperative.voting.core.repository;

import com.cooperative.voting.domain.VoteSessionVO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface VoteSessionRepository extends MongoRepository<VoteSessionVO, ObjectId> {

    VoteSessionVO findBySession(String session);
}
