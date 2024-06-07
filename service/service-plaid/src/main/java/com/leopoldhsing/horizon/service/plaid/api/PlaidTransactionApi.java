package com.leopoldhsing.horizon.service.plaid.api;

import com.leopoldhsing.horizon.model.dto.GeneralResponseDto;
import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.service.plaid.service.IPlaidTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inner/plaid/transaction")
public class PlaidTransactionApi {

    @Autowired
    private IPlaidTransactionService plaidTransactionService;

    @GetMapping("/{accountId}")
    public ResponseEntity<GeneralResponseDto<List<TransactionDto>>> getTransactionsFromPlaidByAccountId(@PathVariable Long accountId) {
        List<TransactionDto> transactionDtoList = plaidTransactionService.getTransactionsByAccountId(accountId);

        return ResponseEntity.ok(new GeneralResponseDto<>(transactionDtoList));
    }

}
