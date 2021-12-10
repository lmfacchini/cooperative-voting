package com.cooperative.voting.bridge.to;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.io.Serializable;

@Data
@ApiModel
public class QuestionTO implements Serializable {

    @Null
    private String id;


    @NotBlank
    @ApiModelProperty(name = "name", required = true)
    private String name;

    @NotBlank
    @ApiModelProperty(name = "description", required = true)
    private String description;
}
