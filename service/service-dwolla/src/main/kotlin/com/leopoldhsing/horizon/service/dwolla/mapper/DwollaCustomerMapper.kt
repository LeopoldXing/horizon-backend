package com.leopoldhsing.horizon.service.dwolla.mapper

import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto
import com.leopoldhsing.horizon.model.entity.DwollaCustomer
import org.springframework.beans.BeanUtils

class DwollaCustomerMapper {

    fun mapToDwollaCustomer(dwollaCustomerDto: DwollaCustomerDto): DwollaCustomer {
        var dwollaCustomer: DwollaCustomer = DwollaCustomer()
        BeanUtils.copyProperties(dwollaCustomerDto, dwollaCustomer)
        dwollaCustomer
        return dwollaCustomer
    }

}
