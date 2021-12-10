package com.cooperative.voting.bridge.to;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class VotingInProgressTO implements Serializable {

    private String question;

    private Set<String> associates;

    public VotingInProgressTO() {
        associates = new HashSet<>();
    }
}
