package com.leopoldhsing.horizon.service.transaction.controller;

import com.leopoldhsing.horizon.model.dto.GeneralResponseDto;
import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.model.vo.TransactionResponseVo;
import com.leopoldhsing.horizon.model.vo.TransactionVo;
import com.leopoldhsing.horizon.service.transaction.mapper.TransactionMapper2;
import com.leopoldhsing.horizon.service.transaction.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @Autowired
    private TransactionMapper2 transactionMapper;

    @GetMapping("/account/{accountId}")
    public ResponseEntity<GeneralResponseDto<List<TransactionResponseVo>>> getTransactionListByAccountId(
            @PathVariable("accountId") Long accountId
    ) {
        List<TransactionDto> transactionDtoList = transactionService.getTransactionListByAccountId(accountId);

        List<TransactionResponseVo> responseVoList = transactionDtoList
                .stream()
                .map(transactionMapper::mapToTransactionResponseVo)
                .toList();

        return ResponseEntity.ok(new GeneralResponseDto<>(responseVoList));
    }

    @PostMapping
    public ResponseEntity<GeneralResponseDto<TransactionResponseVo>> createTransaction(@RequestBody TransactionVo transactionVo) {
        TransactionDto transactionDto = transactionService.createTransaction(transactionVo);
        TransactionResponseVo responseVo = transactionMapper.mapToTransactionResponseVo(transactionDto);

        return ResponseEntity.ok(new GeneralResponseDto<>(responseVo));
    }

}
