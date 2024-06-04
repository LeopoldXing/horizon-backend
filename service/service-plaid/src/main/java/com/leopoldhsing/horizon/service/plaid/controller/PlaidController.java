package com.leopoldhsing.horizon.service.plaid.controller;

import com.leopoldhsing.horizon.model.dto.GeneralResponseDto;
import com.leopoldhsing.horizon.service.plaid.service.IPlaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/plaid")
public class PlaidController {

    @Autowired
    private IPlaidService plaidService;

    @PostMapping("/exchange-public-token")
    public ResponseEntity<GeneralResponseDto<Boolean>> exchangePublicToken(@RequestBody String publicToken) {
        Boolean res = false;
        try {
            res = plaidService.exchangePublicToken(publicToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(res);

        return ResponseEntity.status(HttpStatus.OK).body(new GeneralResponseDto<>(res));
    }

}
