package com.leopoldhsing.horizon.service.dwolla.api

import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto
import com.leopoldhsing.horizon.model.vo.DwollaCustomerCreationVo
import com.leopoldhsing.horizon.service.dwolla.service.IDwollaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/inner/dwolla")
class DwollaFeignApi @Autowired constructor(private val dwollaService: IDwollaService) {

    @PostMapping("/customer")
    fun createDwollaCustomer(@RequestBody vo: DwollaCustomerCreationVo): DwollaCustomerDto {
        return DwollaCustomerDto()
    }
}
