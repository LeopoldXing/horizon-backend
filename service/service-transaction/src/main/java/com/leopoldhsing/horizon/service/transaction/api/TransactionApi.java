package com.leopoldhsing.horizon.service.transaction.api;

import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.service.transaction.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inner/transaction")
public class TransactionApi {

    @Autowired
    private ITransactionService transactionService;

    @PostMapping("/list")
    public void saveTransactionList(@RequestBody List<TransactionDto> transactionDtoList) {
        transactionService.saveTransactionList(transactionDtoList);
    }
}
