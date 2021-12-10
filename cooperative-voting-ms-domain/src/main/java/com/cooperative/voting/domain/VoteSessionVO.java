package com.cooperative.voting.domain;

import com.cooperative.voting.bridge.constants.VoteType;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Data
@Document(collection = "votingSession")
public class VoteSessionVO {

    @Id
    private ObjectId id;

    @Field
    private Long expires;


    @Field
    private TimeUnit timeUnit;


    @Field
    private String question;

    @Field
    private LocalDateTime datetime;


    @Field
    private String session;


    @Field
    private Map<VoteType, Integer> votes;
}
