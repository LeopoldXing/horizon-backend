package com.leopoldhsing.horizon.service.dwolla.mapper

import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto
import com.leopoldhsing.horizon.model.entity.DwollaCustomer
import com.leopoldhsing.horizon.model.enumeration.DwollaCustomerStatus
import com.leopoldhsing.horizon.model.enumeration.DwollaCustomerType
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Component

@Component
class DwollaCustomerMapper {

    fun mapToDwollaCustomer(dwollaCustomerDto: DwollaCustomerDto): DwollaCustomer {
        val dwollaCustomer = DwollaCustomer()
        BeanUtils.copyProperties(dwollaCustomerDto, dwollaCustomer)
        dwollaCustomer.customerType = dwollaCustomerDto.customerType?.toString()
        dwollaCustomer.customerStatus = dwollaCustomerDto.customerStatus?.toString()
        return dwollaCustomer
    }

    fun mapToDwollaCustomerDto(dwollaCustomer: DwollaCustomer): DwollaCustomerDto {
        val dwollaCustomerDto = DwollaCustomerDto()
        BeanUtils.copyProperties(dwollaCustomer, dwollaCustomerDto)
        dwollaCustomerDto.customerStatus = DwollaCustomerStatus.valueOf(dwollaCustomer.customerStatus)
        dwollaCustomerDto.customerType = DwollaCustomerType.valueOf(dwollaCustomer.customerType)
        return dwollaCustomerDto
    }

}
