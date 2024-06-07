package com.leopoldhsing.horizon.service.plaid.controller;

import com.leopoldhsing.horizon.common.utils.RequestUtil;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.GeneralResponseDto;
import com.leopoldhsing.horizon.model.mapper.AccountMapper;
import com.leopoldhsing.horizon.service.plaid.service.IPlaidAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/plaid")
public class PlaidAccountController {

    @Autowired
    private IPlaidAccountService plaidAccountService;

    @GetMapping("/accounts")
    public ResponseEntity<GeneralResponseDto<List<AccountDto>>> getAccounts() {
        Long userId = RequestUtil.getUid();
        List<AccountDto> res = null;
        try {
            res = plaidAccountService.getAccountsFromPlaidByUserId(userId).stream().map(AccountMapper::mapToAccountDto).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(new GeneralResponseDto<>(res));
    }

}
