package com.leopoldhsing.horizon.service.dwolla.service.impl

import com.dwolla.Dwolla
import com.dwolla.api.shared.DateOfBirth
import com.dwolla.http.JsonBody
import com.dwolla.shared.USState
import com.fasterxml.jackson.databind.ObjectMapper
import com.leopoldhsing.horizon.common.utils.exception.ResourceNotFoundException
import com.leopoldhsing.horizon.model.dto.AccountDto
import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto
import com.leopoldhsing.horizon.model.dto.TransactionDto
import com.leopoldhsing.horizon.model.entity.DwollaCustomer
import com.leopoldhsing.horizon.model.enumeration.DwollaCustomerStatus
import com.leopoldhsing.horizon.model.enumeration.DwollaCustomerType
import com.leopoldhsing.horizon.model.vo.DwollaCustomerCreationVo
import com.leopoldhsing.horizon.service.dwolla.mapper.DwollaCustomerMapper
import com.leopoldhsing.horizon.service.dwolla.repository.DwollaCustomerRepository
import com.leopoldhsing.horizon.service.dwolla.service.IDwollaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils

@Service
class DwollaServiceImpl @Autowired constructor(
    private val dwollaRepository: DwollaCustomerRepository,
    private val dwollaClient: Dwolla,
    private val dwollaCustomerMapper: DwollaCustomerMapper,
    private val objectMapper: ObjectMapper
) : IDwollaService {

    /**
     * create verified personal customer
     */
    override fun createVerifiedPersonalCustomer(vo: DwollaCustomerCreationVo): DwollaCustomerDto {
        // 1. convert dwollaCustomerVo to dwollaCustomer
        val dwollaCustomer = DwollaCustomer()
        dwollaCustomer.customerType = DwollaCustomerType.PERSONAL_VERIFIED_CUSTOMER.toString()
        dwollaCustomer.customerStatus = DwollaCustomerStatus.VERIFIED.toString()

        // 2. create dwolla customer
        val dobYear = vo.dateOfBirth.split("-")[0]
        val dobMonth = vo.dateOfBirth.split("-")[1]
        val dobDay = vo.dateOfBirth.split("-")[2]
        val verifiedPersonalCustomer = dwollaClient.customers.createVerifiedPersonal(
            firstName = vo.firstName,
            lastName = vo.lastName,
            email = vo.email,
            address1 = vo.address1,
            city = vo.city,
            state = USState.AK,
            postalCode = vo.postalCode,
            dateOfBirth = DateOfBirth(year = dobYear, month = dobMonth, day = dobDay),
            ssn = vo.ssn
        )

        // 3. save verifiedPersonalCustomer into database
        val dwollaCustomerUrl = verifiedPersonalCustomer._links["self"]!!.href
        dwollaCustomer.dwollaCustomerUrl = dwollaCustomerUrl
        dwollaRepository.save(dwollaCustomer)

        // 4. return DwollaCustomerDto
        return dwollaCustomerMapper.mapToDwollaCustomerDto(dwollaCustomer)
    }

    /**
     * create verified business customer
     */
    override fun createVerifiedBusinessCustomer(vo: DwollaCustomerCreationVo): DwollaCustomerDto {
        return DwollaCustomerDto()
    }

    /**
     * create unverified customer
     */
    override fun createUnverifiedCustomer(vo: DwollaCustomerCreationVo): DwollaCustomerDto {
        return DwollaCustomerDto()
    }

    /**
     * create receive-only customer
     */
    override fun createReceiveOnlyCustomer(vo: DwollaCustomerCreationVo): DwollaCustomerDto {
        return DwollaCustomerDto()
    }

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

    override fun getDwollaCustomerById(dwollaCustomerId: Long): DwollaCustomerDto {
        val dwollaCustomer: DwollaCustomer = dwollaRepository.findById(dwollaCustomerId)
            .orElseThrow { throw ResourceNotFoundException("DwollaCustomer", "dwollaCustomerId", dwollaCustomerId.toString()) }

        return dwollaCustomerMapper.mapToDwollaCustomerDto(dwollaCustomer)
    }

    override fun createTransfer(transactionDto: TransactionDto?): TransactionDto {
        return TransactionDto()
    }
}
