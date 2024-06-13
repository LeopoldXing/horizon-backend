package com.leopoldhsing.horizon.service.dwolla.service

import com.leopoldhsing.horizon.model.dto.AccountDto
import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto
import com.leopoldhsing.horizon.model.dto.TransactionDto
import com.leopoldhsing.horizon.model.vo.DwollaCustomerCreationVo

interface IDwollaService {

    fun createVerifiedPersonalCustomer(dwollaCustomerVo: DwollaCustomerCreationVo): DwollaCustomerDto
    fun createVerifiedBusinessCustomer(dwollaCustomerVo: DwollaCustomerCreationVo): DwollaCustomerDto
    fun createUnverifiedCustomer(dwollaCustomerVo: DwollaCustomerCreationVo): DwollaCustomerDto
    fun createReceiveOnlyCustomer(dwollaCustomerVo: DwollaCustomerCreationVo): DwollaCustomerDto
    fun createFundingSource(dwollaCustomerId: String, accountDto: AccountDto, processorToken: String): String
    fun getDwollaCustomerById(dwollaCustomerId: Long): DwollaCustomerDto
    fun createTransfer(transactionDto: TransactionDto?): TransactionDto

}
