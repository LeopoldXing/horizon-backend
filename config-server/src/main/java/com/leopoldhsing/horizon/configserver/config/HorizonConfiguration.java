package com.leopoldhsing.horizon.configserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "horizon")
public class HorizonConfiguration {

}
