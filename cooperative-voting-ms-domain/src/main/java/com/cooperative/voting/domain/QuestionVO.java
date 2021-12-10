package com.cooperative.voting.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "question")
public class QuestionVO {

    @Id
    private ObjectId id;


    @Field("name")
    private String name;

    @Field("description")
    private String description;
}
