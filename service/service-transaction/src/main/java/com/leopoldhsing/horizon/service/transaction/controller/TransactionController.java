package com.leopoldhsing.horizon.service.transaction.controller;

import com.leopoldhsing.horizon.model.dto.GeneralResponseDto;
import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.model.mapper.TransactionMapper;
import com.leopoldhsing.horizon.model.vo.TransactionResponseVo;
import com.leopoldhsing.horizon.service.transaction.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @GetMapping("/{accountId}")
    public ResponseEntity<GeneralResponseDto<List<TransactionResponseVo>>> getTransactionListByAccountId(@PathVariable("accountId") Long accountId) {
        List<TransactionDto> transactionDtoList = transactionService.getTransactionListByAccountId(accountId);

        List<TransactionResponseVo> responseVoList = transactionDtoList
                .stream()
                .map(TransactionMapper::mapToTransactionResponseVo).toList();

        return ResponseEntity.ok(new GeneralResponseDto<>(responseVoList));
    }

}
