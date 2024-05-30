package com.leopoldhsing.horizon.service.dwolla

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@EntityScan(basePackages = ["com.leopoldhsing.horizon.model.entity"])
@SpringBootApplication
class DwollaApplication

fun main(args: Array<String>) {
    runApplication<DwollaApplication>(*args)
}
