package com.leopoldhsing.horizon.feign.dwolla;

import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto;
import com.leopoldhsing.horizon.model.dto.TransferCreationDto;
import com.leopoldhsing.horizon.model.enumeration.DwollaCustomerType;
import com.leopoldhsing.horizon.model.vo.DwollaCustomerCreationVo;
import org.springframework.stereotype.Component;

@Component
public class DwollaFeignClientFallback implements DwollaFeignClient{

    @Override
    public DwollaCustomerDto createDwollaCustomer(DwollaCustomerCreationVo vo, DwollaCustomerType type) {
        return null;
    }

    @Override
    public String createFundingSource(String dwollaCustomerId, String processorToken, AccountDto accountDto) {
        return "";
    }

    @Override
    public DwollaCustomerDto getDwollaCustomerById(Long dwollaCustomerId) {
        return null;
    }

    @Override
    public String createTransfer(TransferCreationDto transferCreationDto) {
        return "";
    }
}
