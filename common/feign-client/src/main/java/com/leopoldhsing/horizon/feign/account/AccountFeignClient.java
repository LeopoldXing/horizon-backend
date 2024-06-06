package com.leopoldhsing.horizon.feign.account;

import com.leopoldhsing.horizon.model.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("account")
public interface AccountFeignClient {

    @GetMapping("/api/v1/inner/account/{uid}")
    List<AccountDto> getAccountsByUserId(@PathVariable("uid") Long uid);

}
