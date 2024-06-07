package com.leopoldhsing.horizon.feign.transaction;

import com.leopoldhsing.horizon.model.dto.TransactionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("transaction")
public interface TransactionFeignClient {

    @PostMapping("/api/v1/inner/transaction/list")
    void saveTransactionList(@RequestBody List<TransactionDto> transactionDtoList);
}
