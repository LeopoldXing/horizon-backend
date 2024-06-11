package com.leopoldhsing.horizon.service.dwolla.service.impl

import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto
import com.leopoldhsing.horizon.model.vo.DwollaCustomerCreationVo
import com.leopoldhsing.horizon.service.dwolla.repository.DwollaCustomerRepository
import com.leopoldhsing.horizon.service.dwolla.service.IDwollaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DwollaServiceImpl @Autowired constructor(
    private val dwollaRepository: DwollaCustomerRepository
) : IDwollaService {

    override fun createDwollaCustomer(dwollaCustomerVo: DwollaCustomerCreationVo): DwollaCustomerDto {
        return DwollaCustomerDto()
    }
}
