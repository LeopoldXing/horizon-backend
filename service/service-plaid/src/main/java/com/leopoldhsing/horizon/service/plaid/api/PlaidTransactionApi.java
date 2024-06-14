package com.leopoldhsing.horizon.service.plaid.api;

import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.service.plaid.service.IPlaidTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/inner/plaid/transaction")
public class PlaidTransactionApi {

    @Autowired
    private IPlaidTransactionService plaidTransactionService;

    @GetMapping("/{plaidAccountId}")
    public List<TransactionDto> getTransactionsFromPlaidByPlaidAccountId(@PathVariable String plaidAccountId) {
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        try {
            transactionDtoList = plaidTransactionService.getTransactionsByPlaidAccountId(plaidAccountId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transactionDtoList;
    }

}
