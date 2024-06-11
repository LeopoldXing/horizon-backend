package com.leopoldhsing.horizon.service.dwolla.service.impl

import com.dwolla.Dwolla
import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto
import com.leopoldhsing.horizon.model.vo.DwollaCustomerCreationVo
import com.leopoldhsing.horizon.service.dwolla.repository.DwollaCustomerRepository
import com.leopoldhsing.horizon.service.dwolla.service.IDwollaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DwollaServiceImpl @Autowired constructor(
    private val dwollaRepository: DwollaCustomerRepository,
    private val dwollaInstance: Dwolla
) : IDwollaService {

    override fun createDwollaCustomer(dwollaCustomerVo: DwollaCustomerCreationVo): DwollaCustomerDto {
        // 1. convert dwollaCustomerVo to dwollaCustomer

        return DwollaCustomerDto()
    }
}
