package com.leopoldhsing.horizon.feign.account;

import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("account")
public interface AccountFeignClient {

    @GetMapping("/api/v1/inner/account/list/{uid}")
    List<AccountDto> getAccountsByUserId(@PathVariable("uid") Long uid);

    @PostMapping("/api/v1/inner/account/list")
    void saveAccountList(@RequestBody List<Account> accountList);

    @GetMapping("/api/v1/inner/account/{accountId}")
    AccountDto getAccountById(@PathVariable("accountId") Long accountId);
}
