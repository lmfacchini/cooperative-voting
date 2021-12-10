package com.cooperative.voting.bridge.to;

import com.cooperative.voting.bridge.constants.VoteType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
@ApiModel
public class VoteCountTO implements Serializable {

    @ApiModelProperty(name = "question")
    private String question;

    @ApiModelProperty(name = "session")
    private String session;

    @ApiModelProperty(name = "votes")
    private Map<VoteType, Integer> votes;

}
