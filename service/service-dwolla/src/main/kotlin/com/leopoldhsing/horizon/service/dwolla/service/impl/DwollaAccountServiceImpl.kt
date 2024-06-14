package com.leopoldhsing.horizon.service.dwolla.service.impl

import com.dwolla.Dwolla
import com.dwolla.http.JsonBody
import com.fasterxml.jackson.databind.ObjectMapper
import com.leopoldhsing.horizon.model.dto.AccountDto
import com.leopoldhsing.horizon.service.dwolla.service.IDwollaAccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils

@Service
class DwollaAccountServiceImpl @Autowired constructor(
    private val dwollaClient: Dwolla,
    private val objectMapper: ObjectMapper
) : IDwollaAccountService {
    override fun createFundingSource(dwollaCustomerId: String, accountDto: AccountDto, processorToken: String): String {
        val fundingSourceName = "${accountDto.name} ${accountDto.plaidAccountId.substring(0, 5)}"

        // 1. create dwolla auth link
        val authResponse = dwollaClient.post("on-demand-authorizations")
        val responseDataInMap = objectMapper.readValue(authResponse.body, Map::class.java)
        val authLink = responseDataInMap["_links"]

        // 2. check is the funding source already exist
        val existingFundingSourcesResponse = dwollaClient.fundingSources.listByCustomer(dwollaCustomerId, false)
        val existingFundingSourceList = existingFundingSourcesResponse._embedded.fundingSources
        val existingFundingSource = existingFundingSourceList.find { it.name == fundingSourceName }
        if (!ObjectUtils.isEmpty(existingFundingSource)) {
            // funding source already exists
            return existingFundingSourceList[0]._links["self"]!!.href
        }

        // 3. create funding source
        val urlResponse = dwollaClient.post(
            "/customers/${dwollaCustomerId}/funding-sources",
            JsonBody(
                "name" to fundingSourceName,
                "plaidToken" to processorToken,
                Pair("_links", authLink),
                Pair("accountNumber", accountDto.id.toString())
            )
        )

        val url = urlResponse.headers.get("Location")
        return url.toString()
    }
}
