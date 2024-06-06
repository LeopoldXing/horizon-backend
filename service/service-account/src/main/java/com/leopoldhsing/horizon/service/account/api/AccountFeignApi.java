package com.leopoldhsing.horizon.service.account.api;

import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.service.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inner/account")
public class AccountFeignApi {

    @Autowired
    private IAccountService accountService;

    @GetMapping("/{uid}")
    public List<AccountDto> getAccountsByUserId(@PathVariable("uid") Long uid) {
        List<AccountDto> accountByUserId = accountService.getAccountByUserId(uid);
        return accountByUserId;
    }

    @PostMapping("/list")
    public void saveAccountList(@RequestBody List<AccountDto> accountDtoList) {
        accountService.saveAccountList(accountDtoList);
    }

}
