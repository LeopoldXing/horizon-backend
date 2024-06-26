package com.leopoldhsing.horizon.service.dwolla.controller

import com.leopoldhsing.horizon.service.dwolla.config.DwollaConfigurationProperties
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/inner/dwolla")
class DwollaController(private val dwollaConfigurationProperties: DwollaConfigurationProperties) {

}
