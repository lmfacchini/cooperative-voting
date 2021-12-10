package com.cooperative.voting.domain;

import com.cooperative.voting.bridge.constants.VoteType;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VoteVO {


    @Field
    private VoteType value;


    @Field
    private String question;
}
