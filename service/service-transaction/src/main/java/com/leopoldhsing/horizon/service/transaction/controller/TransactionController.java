package com.leopoldhsing.horizon.service.transaction.controller;

import com.leopoldhsing.horizon.model.dto.GeneralResponseDto;
import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.model.vo.TransactionCreationVo;
import com.leopoldhsing.horizon.model.vo.TransactionResponseVo;
import com.leopoldhsing.horizon.service.transaction.mapper.TransactionMapper2;
import com.leopoldhsing.horizon.service.transaction.service.ITransactionService;
import io.github.resilience4j.retry.annotation.Retry;
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

    @Retry(name = "getTransactionListByAccountIdRetry", fallbackMethod = "getTransactionListByAccountIdFallback")
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

    public ResponseEntity<GeneralResponseDto<List<TransactionResponseVo>>> getTransactionListByAccountIdFallback(
            Throwable throwable,
            @PathVariable("accountId") Long accountId
    ) {
        return ResponseEntity.ok(new GeneralResponseDto<>(null));
    }

    @Retry(name = "createTransactionRetry", fallbackMethod = "createTransactionFallback")
    @PostMapping
    public ResponseEntity<GeneralResponseDto<TransactionResponseVo>> createTransaction(
            @RequestBody TransactionCreationVo transactionCreationVo
    ) {
        TransactionDto transactionDto = transactionService.createTransaction(transactionCreationVo);
        TransactionResponseVo responseVo = transactionMapper.mapToTransactionResponseVo(transactionDto);

        return ResponseEntity.ok(new GeneralResponseDto<>(responseVo));
    }

    public ResponseEntity<GeneralResponseDto<TransactionResponseVo>> createTransactionFallback(
            Throwable throwable,
            @RequestBody TransactionCreationVo transactionCreationVo
    ) {
        return ResponseEntity.ok(new GeneralResponseDto<>(null));
    }

}
