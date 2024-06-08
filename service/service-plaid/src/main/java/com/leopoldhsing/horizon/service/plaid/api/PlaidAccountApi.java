package com.leopoldhsing.horizon.service.plaid.api;

import com.leopoldhsing.horizon.model.dto.AccountDto;
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
    public List<AccountDto> getAccountsFromPlaidByUserId(@PathVariable Long uid) {
        List<AccountDto> accountDtoList = null;
        try {
            accountDtoList = plaidAccountService.getAccountsFromPlaidByUserId(uid);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return accountDtoList;
    }

}
