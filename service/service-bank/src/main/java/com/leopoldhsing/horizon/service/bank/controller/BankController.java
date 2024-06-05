package com.leopoldhsing.horizon.service.bank.controller;

import com.leopoldhsing.horizon.common.utils.RequestUtil;
import com.leopoldhsing.horizon.model.dto.BankDto;
import com.leopoldhsing.horizon.model.dto.GeneralResponseDto;
import com.leopoldhsing.horizon.service.bank.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController {

    @Autowired
    private IBankService bankService;

    @GetMapping("/list")
    public ResponseEntity<GeneralResponseDto<List<BankDto>>> getBanks() {
        // 1. get current user id
        Long userId = RequestUtil.getUid();

        // 2. get bank list
        List<BankDto> bankList = bankService.getBankListByUserId(userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new GeneralResponseDto<>(bankList));
    }
}
