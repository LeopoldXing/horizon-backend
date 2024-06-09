package com.leopoldhsing.horizon.service.account.controller;

import com.leopoldhsing.horizon.common.utils.RequestUtil;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.GeneralResponseDto;
import com.leopoldhsing.horizon.model.vo.AccountResponseVo;
import com.leopoldhsing.horizon.service.account.mapper.AccountMapper2;
import com.leopoldhsing.horizon.service.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private AccountMapper2 accountMapper;

    @GetMapping("/list")
    public ResponseEntity<GeneralResponseDto<List<AccountResponseVo>>> getAccountListByUserId() {
        Long userId = RequestUtil.getUid();
        List<AccountDto> dtoList = accountService.getAccountByUserId(userId);
        List<AccountResponseVo> res = dtoList.stream().map(accountMapper::mapToAccountResponseVo).toList();
        return ResponseEntity.ok(new GeneralResponseDto<>(res));
    }
}
