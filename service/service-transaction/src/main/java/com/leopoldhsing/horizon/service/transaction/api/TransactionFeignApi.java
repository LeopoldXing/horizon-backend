package com.leopoldhsing.horizon.service.transaction.api;

import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.model.vo.TransactionResponseVo;
import com.leopoldhsing.horizon.service.transaction.mapper.TransactionMapper2;
import com.leopoldhsing.horizon.service.transaction.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inner/transaction")
public class TransactionFeignApi {

    @Autowired
    private ITransactionService transactionService;

    @Autowired
    private TransactionMapper2 transactionMapper;

    @PostMapping("/list")
    public void saveTransactionList(@RequestBody List<TransactionDto> transactionDtoList) {
        transactionService.saveTransactionList(transactionDtoList);
    }

    @GetMapping("/accountId/{accountId}")
    public List<TransactionResponseVo> getTransactionListByAccountId(@PathVariable("accountId") Long accountId) {
        List<TransactionDto> dtoList = transactionService.getTransactionListByAccountId(accountId);
        List<TransactionResponseVo> res = dtoList.stream().map(transactionMapper::mapToTransactionResponseVo).toList();
        return res;
    }
}
