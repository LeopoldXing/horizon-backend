package com.leopoldhsing.horizon.service.dwolla

import com.dwolla.Dwolla
import com.dwolla.DwollaEnvironment
import com.leopoldhsing.horizon.common.utils.exception.DwollaConfigurationException
import com.leopoldhsing.horizon.service.dwolla.config.DwollaConfigurationProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean

@EnableFeignClients(basePackages = ["com.leopoldhsing.horizon.feign"])
@EntityScan(basePackages = ["com.leopoldhsing.horizon.model.entity"])
@SpringBootApplication(scanBasePackages = ["com.leopoldhsing.horizon"])
class DwollaApplication @Autowired constructor(
    private val configurationProperties: DwollaConfigurationProperties
) {
    @Bean
    fun createDwollaInstance(): Dwolla {
        if (configurationProperties.env.isEmpty()) throw DwollaConfigurationException()
        val environment = when {
            (configurationProperties.env.lowercase() == "sandbox") -> DwollaEnvironment.SANDBOX
            else -> DwollaEnvironment.PRODUCTION
        }
        return Dwolla(
            key = configurationProperties.key,
            secret = configurationProperties.secret,
            environment = environment
        )
    }
}

fun main(args: Array<String>) {
    runApplication<DwollaApplication>(*args)
}
