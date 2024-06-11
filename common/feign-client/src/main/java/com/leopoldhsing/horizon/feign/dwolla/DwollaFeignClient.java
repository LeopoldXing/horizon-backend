package com.leopoldhsing.horizon.feign.dwolla;

import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto;
import com.leopoldhsing.horizon.model.vo.DwollaCustomerCreationVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("dwolla")
public interface DwollaFeignClient {

    @PostMapping("/api/v1/inner/dwolla/customer")
    DwollaCustomerDto createDwollaCustomer(@RequestBody DwollaCustomerCreationVo vo);
}
