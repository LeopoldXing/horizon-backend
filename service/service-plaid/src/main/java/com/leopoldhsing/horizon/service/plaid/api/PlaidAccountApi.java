package com.leopoldhsing.horizon.service.plaid.api;

import com.leopoldhsing.horizon.model.entity.Account;
import com.leopoldhsing.horizon.service.plaid.service.IPlaidAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/inner/plaid/account")
public class PlaidAccountApi {

    @Autowired
    private IPlaidAccountService plaidAccountService;

    @GetMapping("/list/{uid}")
    public List<Account> getAccountsFromPlaidByUserId(@PathVariable Long uid) {
        List<Account> accounts = null;
        try {
            accounts = plaidAccountService.getAccountsFromPlaidByUserId(uid);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }

}
