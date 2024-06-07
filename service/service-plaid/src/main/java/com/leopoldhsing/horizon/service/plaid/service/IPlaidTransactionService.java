package com.leopoldhsing.horizon.service.plaid.service;

import com.leopoldhsing.horizon.model.dto.TransactionDto;

import java.util.List;

public interface IPlaidTransactionService {

    List<TransactionDto> getTransactionsByAccountId(Long accountId);

}
