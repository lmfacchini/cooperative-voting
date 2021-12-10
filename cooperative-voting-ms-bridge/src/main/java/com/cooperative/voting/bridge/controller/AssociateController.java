package com.cooperative.voting.bridge.controller;

import com.cooperative.voting.bridge.to.AssociateValidationTO;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/associate")
public interface AssociateController {

    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Invalid document (CPF BR)"),
            @ApiResponse(code = 200, message = "Return document status."),
            @ApiResponse(code = 500, message = "Exception"),
    })
    @GetMapping("/@{document}/status")
    ResponseEntity<AssociateValidationTO> status(@ApiParam(name = "document", value = "Document", required = true) @PathVariable("document") String document);


}
