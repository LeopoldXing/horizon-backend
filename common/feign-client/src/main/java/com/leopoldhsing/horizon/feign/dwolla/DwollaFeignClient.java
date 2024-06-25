package com.leopoldhsing.horizon.feign.dwolla;

import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto;
import com.leopoldhsing.horizon.model.dto.TransferCreationDto;
import com.leopoldhsing.horizon.model.enumeration.DwollaCustomerType;
import com.leopoldhsing.horizon.model.vo.DwollaCustomerCreationVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "dwolla", fallback = DwollaFeignClientFallback.class)
public interface DwollaFeignClient {

    @PostMapping("/api/v1/inner/dwolla/customer/{type}")
    DwollaCustomerDto createDwollaCustomer(@RequestBody DwollaCustomerCreationVo vo, @PathVariable DwollaCustomerType type);

    @PostMapping("/api/v1/inner/dwolla/funding-source/{dwollaCustomerId}")
    String createFundingSource(@PathVariable String dwollaCustomerId,
                               @RequestHeader String processorToken,
                               @RequestBody AccountDto accountDto);

    @GetMapping("/api/v1/inner/dwolla/customer/{dwollaCustomerId}")
    DwollaCustomerDto getDwollaCustomerById(@PathVariable Long dwollaCustomerId);

    @PostMapping("/api/v1/inner/dwolla/transfer")
    String createTransfer(@RequestBody TransferCreationDto transferCreationDto);
}
