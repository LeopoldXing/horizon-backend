package com.leopoldhsing.horizon.service.plaid.service.impl;

import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.service.plaid.service.IPlaidTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaidTransactionServiceImpl implements IPlaidTransactionService {
    @Override
    public List<TransactionDto> getTransactionsByAccountId(Long accountId) {
        return List.of();
    }
}
