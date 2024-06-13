package com.leopoldhsing.horizon.service.dwolla.api

import com.leopoldhsing.horizon.model.dto.AccountDto
import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto
import com.leopoldhsing.horizon.model.dto.TransactionDto
import com.leopoldhsing.horizon.model.enumeration.DwollaCustomerType
import com.leopoldhsing.horizon.model.vo.DwollaCustomerCreationVo
import com.leopoldhsing.horizon.service.dwolla.service.IDwollaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/inner/dwolla")
class DwollaFeignApi @Autowired constructor(
    private val dwollaService: IDwollaService
) {

    @PostMapping("/customer/{type}")
    fun createDwollaCustomer(@RequestBody vo: DwollaCustomerCreationVo, @PathVariable type: DwollaCustomerType): DwollaCustomerDto {
        val dwollaCustomerDto = when (type) {
            DwollaCustomerType.PERSONAL_VERIFIED_CUSTOMER -> dwollaService.createVerifiedPersonalCustomer(vo)
            DwollaCustomerType.BUSINESS_VERIFIED_CUSTOMER -> dwollaService.createVerifiedBusinessCustomer(vo)
            DwollaCustomerType.UNVERIFIED_CUSTOMER -> dwollaService.createUnverifiedCustomer(vo)
            DwollaCustomerType.RECEIVE_ONLY_CUSTOMER -> dwollaService.createReceiveOnlyCustomer(vo)
        }
        return dwollaCustomerDto
    }

    @PostMapping("/funding-source/{dwollaCustomerId}")
    fun createFundingSource(
        @PathVariable dwollaCustomerId: String,
        @RequestHeader processorToken: String,
        @RequestBody accountDto: AccountDto
    ): String = dwollaService.createFundingSource(dwollaCustomerId, accountDto, processorToken)

    @GetMapping("/customer/{dwollaCustomerId}")
    fun getDwollaCustomerById(@PathVariable dwollaCustomerId: Long): DwollaCustomerDto {
        return dwollaService.getDwollaCustomerById(dwollaCustomerId)
    }

    @PostMapping("/transfer")
    fun createTransfer(@RequestBody transactionDto: TransactionDto?): TransactionDto{
        return dwollaService.createTransfer(transactionDto)
    }
}
