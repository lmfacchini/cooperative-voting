package com.cooperative.voting.bridge.to;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.concurrent.TimeUnit;

@Data
@ApiModel
public class VotingOpenenSessionTO {

    @NotNull
    @Positive
    @ApiModelProperty(name = "expires", required = true, example = "1")
    private Long expires = 1L;

    @NotNull
    @ApiModelProperty(name = "timeUnit", required = true, example = "MINUTES")
    private TimeUnit timeUnit = TimeUnit.MINUTES;

    @NotBlank
    @ApiModelProperty(name = "question", required = true)
    private String question;
}
