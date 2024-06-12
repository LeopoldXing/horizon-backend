package com.leopoldhsing.horizon.feign.plaid;

import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.ProcessorTokenCreationDto;
import com.leopoldhsing.horizon.model.dto.TransactionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("plaid")
public interface PlaidFeignClient {

    @GetMapping("/api/v1/inner/plaid/account/list/{uid}")
    List<AccountDto> getAccountsFromPlaidByUserId(@PathVariable Long uid);

    @GetMapping("/api/v1/inner/plaid/transaction/{plaidAccountId}")
    List<TransactionDto> getTransactionsFromPlaidByPlaidAccountId(@PathVariable String plaidAccountId);

    @DeleteMapping("/api/v1/inner/plaid/access-token")
    void deleteAccessToken();

    @PostMapping("/api/v1/inner/plaid/processor-token")
    String getProcessorToken(@RequestBody ProcessorTokenCreationDto processorTokenCreationDto);
}
