package com.leopoldhsing.horizon.service.dwolla.service

import com.leopoldhsing.horizon.model.dto.AccountDto

interface IDwollaAccountService {
    fun createFundingSource(dwollaCustomerId: String, accountDto: AccountDto, processorToken: String): String
}
