package com.leopoldhsing.horizon.feign.plaid;

import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.ProcessorTokenCreationDto;
import com.leopoldhsing.horizon.model.dto.TransactionDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlaidFeignClientFallback implements PlaidFeignClient{

    @Override
    public List<AccountDto> getAccountsFromPlaidByUserId(Long uid) {
        return List.of();
    }

    @Override
    public List<TransactionDto> getTransactionsFromPlaidByPlaidAccountId(String plaidAccountId) {
        return List.of();
    }

    @Override
    public void deleteAccessToken() {

    }

    @Override
    public String getProcessorToken(ProcessorTokenCreationDto processorTokenCreationDto) {
        return "";
    }
}
