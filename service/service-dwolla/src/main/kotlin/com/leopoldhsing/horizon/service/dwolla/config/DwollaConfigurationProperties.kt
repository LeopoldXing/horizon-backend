package com.leopoldhsing.horizon.service.dwolla.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "dwolla")
data class DwollaConfigurationProperties(
    var key: String = "",
    var secret: String = "",
    var baseUrl: String = "",
    var env: String = ""
)
