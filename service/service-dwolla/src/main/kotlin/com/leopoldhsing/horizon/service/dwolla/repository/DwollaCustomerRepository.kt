package com.leopoldhsing.horizon.service.dwolla.repository

import com.leopoldhsing.horizon.model.entity.DwollaCustomer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DwollaCustomerRepository : JpaRepository<DwollaCustomer, Long> {
}
