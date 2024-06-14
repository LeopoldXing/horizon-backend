package com.leopoldhsing.horizon.service.dwolla.service

import com.leopoldhsing.horizon.model.dto.TransferCreationDto

interface IDwollaTransferService {
    fun createTransfer(transferCreationDto: TransferCreationDto): String
}
