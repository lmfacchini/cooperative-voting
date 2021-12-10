package com.cooperative.voting.bridge.to;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Null;

@Data
@AllArgsConstructor
@ApiModel
public class VotingOpenedSessionTO {

    @Null
    @ApiModelProperty(name = "session")
    private String session;
}
