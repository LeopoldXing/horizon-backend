package com.leopoldhsing.horizon.service.dwolla.api

import com.leopoldhsing.horizon.model.dto.AccountDto
import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto
import com.leopoldhsing.horizon.model.dto.TransferCreationDto
import com.leopoldhsing.horizon.model.enumeration.DwollaCustomerType
import com.leopoldhsing.horizon.model.vo.DwollaCustomerCreationVo
import com.leopoldhsing.horizon.service.dwolla.service.IDwollaAccountService
import com.leopoldhsing.horizon.service.dwolla.service.IDwollaCustomerService
import com.leopoldhsing.horizon.service.dwolla.service.IDwollaTransferService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/inner/dwolla")
class DwollaFeignApi @Autowired constructor(
    private val dwollaCustomerService: IDwollaCustomerService,
    private val dwollaAccountService: IDwollaAccountService,
    private val dwollaTransferService: IDwollaTransferService
) {

    @PostMapping("/customer/{type}")
    fun createDwollaCustomer(@RequestBody vo: DwollaCustomerCreationVo, @PathVariable type: DwollaCustomerType): DwollaCustomerDto {
        val dwollaCustomerDto = when (type) {
            DwollaCustomerType.PERSONAL_VERIFIED_CUSTOMER -> dwollaCustomerService.createVerifiedPersonalCustomer(vo)
            DwollaCustomerType.BUSINESS_VERIFIED_CUSTOMER -> dwollaCustomerService.createVerifiedBusinessCustomer(vo)
            DwollaCustomerType.UNVERIFIED_CUSTOMER -> dwollaCustomerService.createUnverifiedCustomer(vo)
            DwollaCustomerType.RECEIVE_ONLY_CUSTOMER -> dwollaCustomerService.createReceiveOnlyCustomer(vo)
        }
        return dwollaCustomerDto
    }

    @PostMapping("/funding-source/{dwollaCustomerId}")
    fun createFundingSource(
        @PathVariable dwollaCustomerId: String,
        @RequestHeader processorToken: String,
        @RequestBody accountDto: AccountDto
    ): String = dwollaAccountService.createFundingSource(dwollaCustomerId, accountDto, processorToken)

    @GetMapping("/customer/{dwollaCustomerId}")
    fun getDwollaCustomerById(@PathVariable dwollaCustomerId: Long): DwollaCustomerDto {
        return dwollaCustomerService.getDwollaCustomerById(dwollaCustomerId)
    }

    @PostMapping("/transfer")
    fun createTransfer(@RequestBody transferCreationDto: TransferCreationDto): String{
        return dwollaTransferService.createTransfer(transferCreationDto)
    }
}
