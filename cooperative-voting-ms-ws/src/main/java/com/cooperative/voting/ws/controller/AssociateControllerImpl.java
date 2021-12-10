package com.cooperative.voting.ws.controller;

import com.cooperative.voting.bridge.constants.AssociateStatus;
import com.cooperative.voting.bridge.controller.AssociateController;
import com.cooperative.voting.bridge.to.AssociateValidationTO;
import com.cooperative.voting.ws.utils.CPFValidator;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssociateControllerImpl implements AssociateController {


    @Override
    public ResponseEntity<AssociateValidationTO> status(String document) {


        if(!CPFValidator.isValid(document)){
            return ResponseEntity.notFound().build();
        }

        final int number = RandomUtils.nextInt(0, 10);
        if((number % 2) == 0){

            return ResponseEntity.ok(new AssociateValidationTO(AssociateStatus.ABLE_TO_VOTE));
        }else{
            return ResponseEntity.ok(new AssociateValidationTO(AssociateStatus.UNABLE_TO_VOTE));
        }
    }
}
