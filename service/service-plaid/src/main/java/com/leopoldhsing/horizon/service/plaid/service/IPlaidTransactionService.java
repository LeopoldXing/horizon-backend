package com.leopoldhsing.horizon.service.plaid.service;

import com.leopoldhsing.horizon.model.dto.TransactionDto;

import java.io.IOException;
import java.util.List;

public interface IPlaidTransactionService {

    List<TransactionDto> getTransactionsByPlaidAccountId(String plaidAccountId) throws IOException;

}
