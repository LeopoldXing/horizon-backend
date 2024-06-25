package com.leopoldhsing.horizon.feign.account;

import com.leopoldhsing.horizon.model.dto.AccountAlignmentDto;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.CreateFundingSourceDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountFeignClientFallback implements AccountFeignClient {

    @Override
    public List<AccountDto> getAccountsByUserId(Long uid) {
        return List.of();
    }

    @Override
    public List<AccountDto> saveAccountList(List<AccountDto> accountList) {
        return List.of();
    }

    @Override
    public AccountDto getAccountById(Long accountId) {
        return null;
    }

    @Override
    public AccountDto getAccountByPlaidAccountId(String plaidAccountId) {
        return null;
    }

    @Override
    public List<AccountDto> alignAccountInfo(AccountAlignmentDto accountAlignmentDto) {
        return List.of();
    }

    @Override
    public String createFundingSource(CreateFundingSourceDto createFundingSourceDto) {
        return "";
    }

    @Override
    public Long getOwnerIdByAccountId(Long accountId) {
        return 0L;
    }
}
