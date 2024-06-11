package com.leopoldhsing.horizon.service.dwolla

import com.dwolla.Dwolla
import com.dwolla.DwollaEnvironment
import com.leopoldhsing.horizon.service.dwolla.config.DwollaConfigurationProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@EntityScan(basePackages = ["com.leopoldhsing.horizon.model.entity"])
@SpringBootApplication
class DwollaApplication @Autowired constructor(private val configurationProperties: DwollaConfigurationProperties) {

    fun main(args: Array<String>) {
        runApplication<DwollaApplication>(*args)
    }

    @Bean
    fun createDwollaInstance(): Dwolla {
        val environment = when {
            (configurationProperties.env == "SANDBOX") -> DwollaEnvironment.SANDBOX
            else -> DwollaEnvironment.PRODUCTION
        }
        return Dwolla(
            key = configurationProperties.key,
            secret = configurationProperties.secret,
            environment = environment
        )
    }
}
