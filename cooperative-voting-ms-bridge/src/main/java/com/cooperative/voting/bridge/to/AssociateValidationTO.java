package com.cooperative.voting.bridge.to;

import com.cooperative.voting.bridge.constants.AssociateStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AssociateValidationTO implements Serializable {

    private AssociateStatus status;
}
