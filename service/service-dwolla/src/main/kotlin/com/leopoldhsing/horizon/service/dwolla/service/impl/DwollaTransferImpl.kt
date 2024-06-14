package com.leopoldhsing.horizon.service.dwolla.service.impl

import com.dwolla.Dwolla
import com.dwolla.http.JsonBody
import com.leopoldhsing.horizon.model.dto.TransferCreationDto
import com.leopoldhsing.horizon.service.dwolla.service.IDwollaTransferService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DwollaTransferImpl @Autowired constructor(
    val dwollaClient: Dwolla
) : IDwollaTransferService {
    override fun createTransfer(transferCreationDto: TransferCreationDto): String {
        // 1. request
        val body = JsonBody(
            Pair(
                "_links", JsonBody(
                    Pair(
                        "source", JsonBody(
                            Pair("href", transferCreationDto.sourceFundingSourceUrl)
                        )
                    ),
                    Pair(
                        "destination", JsonBody(
                            Pair("href", transferCreationDto.destinationFundingSourceUrl)
                        )
                    )
                )
            ),
            Pair(
                "amount", JsonBody(
                    Pair("value", transferCreationDto.amount.toString()),
                    Pair("currency", "USD")
                )
            )
        )

        // 2. create transfer
        val response = dwollaClient.post("transfers", body)

        // 3. parse response
        val location = response.headers.get("location")
        return location!!
    }
}
