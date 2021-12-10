package com.cooperative.voting.core.repository;

import com.cooperative.voting.domain.QuestionVO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface QuestionRepository extends MongoRepository<QuestionVO, ObjectId> {

    QuestionVO findByName(String name);
}
