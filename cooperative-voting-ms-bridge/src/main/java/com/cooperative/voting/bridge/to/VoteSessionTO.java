package com.cooperative.voting.bridge.to;

import com.cooperative.voting.bridge.constants.VoteType;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Data
public class VoteSessionTO implements Serializable {


    private Long expires;


    private TimeUnit timeUnit;


    private String question;

    private LocalDateTime datetime;


    private String session;


    private Map<VoteType, Integer> votes;

    public VoteSessionTO() {
        votes = new HashMap<>();
    }
}
