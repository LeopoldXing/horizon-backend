package com.leopoldhsing.horizon.service.bank.controller;

import com.leopoldhsing.horizon.model.dto.BankDto;
import com.leopoldhsing.horizon.model.dto.GeneralResponseDto;
import com.leopoldhsing.horizon.service.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/bank/list/{userId}")
    public ResponseEntity<GeneralResponseDto<List<BankDto>>> getBanksByUserId(@PathVariable Long userId) {
        System.out.println("-------------- userId = " + userId);
        List<BankDto> bankDtos = new ArrayList<>();
        bankDtos.add(new BankDto());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new GeneralResponseDto<>(bankDtos));
    }
}
