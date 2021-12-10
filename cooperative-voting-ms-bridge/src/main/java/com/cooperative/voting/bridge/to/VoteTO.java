package com.cooperative.voting.bridge.to;

import com.cooperative.voting.bridge.constants.VoteType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class VoteTO {

    @NotNull
    @ApiModelProperty(name = "value", required = true)
    private VoteType value;

    @NotBlank
    @ApiModelProperty(name = "associate", required = true)
    private String associate;

    @NotBlank
    @ApiModelProperty(name = "session", required = true)
    private String session;
}
