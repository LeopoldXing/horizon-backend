package com.leopoldhsing.horizon.feign.account;

import com.leopoldhsing.horizon.model.dto.AccountAlignmentDto;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.CreateFundingSourceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "account", fallback = AccountFeignClientFallback.class)
public interface AccountFeignClient {

    @GetMapping("/api/v1/inner/account/list/{uid}")
    List<AccountDto> getAccountsByUserId(@PathVariable("uid") Long uid);

    @PostMapping("/api/v1/inner/account/list")
    List<AccountDto> saveAccountList(@RequestBody List<AccountDto> accountList);

    @GetMapping("/api/v1/inner/account/{accountId}")
    AccountDto getAccountById(@PathVariable("accountId") Long accountId);

    @GetMapping("/api/v1/inner/account/plaid/{plaidAccountId}")
    AccountDto getAccountByPlaidAccountId(@PathVariable String plaidAccountId);

    @PostMapping("/api/v1/inner/account/align")
    List<AccountDto> alignAccountInfo(@RequestBody AccountAlignmentDto accountAlignmentDto);

    @GetMapping("/api/v1/inner/account/funding-source")
    String createFundingSource(@RequestBody CreateFundingSourceDto createFundingSourceDto);

    @GetMapping("/api/v1/inner/account/user/{accountId}")
    Long getOwnerIdByAccountId(@PathVariable("accountId") Long accountId);
}
