package com.leopoldhsing.horizon.service.dwolla.service

import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto
import com.leopoldhsing.horizon.model.vo.DwollaCustomerCreationVo

interface IDwollaService {

    fun createDwollaCustomer(dwollaCustomerVo: DwollaCustomerCreationVo): DwollaCustomerDto

}
