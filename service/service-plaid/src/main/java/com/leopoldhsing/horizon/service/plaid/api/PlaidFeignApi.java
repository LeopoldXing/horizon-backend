package com.leopoldhsing.horizon.service.plaid.api;

import com.leopoldhsing.horizon.service.plaid.service.IPlaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/inner/plaid")
@RestController
public class PlaidFeignApi {

    @Autowired
    private IPlaidService plaidService;

    @DeleteMapping("/access-token")
    public void deleteAccessToken() {
        plaidService.deleteAccessToken();
    }
}
