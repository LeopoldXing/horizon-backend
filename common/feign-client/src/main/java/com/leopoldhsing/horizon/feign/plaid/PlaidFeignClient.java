package com.leopoldhsing.horizon.feign.plaid;

import com.leopoldhsing.horizon.model.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("plaid")
public interface PlaidFeignClient {

    @GetMapping("/api/v1/inner/plaid/list/{uid}")
    List<AccountDto> getAccountsFromPlaidByUserId(@PathVariable Long uid);

}
