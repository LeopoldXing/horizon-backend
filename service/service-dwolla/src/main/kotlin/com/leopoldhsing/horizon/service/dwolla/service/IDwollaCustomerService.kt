package com.leopoldhsing.horizon.service.dwolla.service

import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto
import com.leopoldhsing.horizon.model.vo.DwollaCustomerCreationVo

interface IDwollaCustomerService {

    fun createVerifiedPersonalCustomer(dwollaCustomerVo: DwollaCustomerCreationVo): DwollaCustomerDto
    fun createVerifiedBusinessCustomer(dwollaCustomerVo: DwollaCustomerCreationVo): DwollaCustomerDto
    fun createUnverifiedCustomer(dwollaCustomerVo: DwollaCustomerCreationVo): DwollaCustomerDto
    fun createReceiveOnlyCustomer(dwollaCustomerVo: DwollaCustomerCreationVo): DwollaCustomerDto
    fun getDwollaCustomerById(dwollaCustomerId: Long): DwollaCustomerDto
}
