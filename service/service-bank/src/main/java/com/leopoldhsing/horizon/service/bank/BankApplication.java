package com.leopoldhsing.horizon.service.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.leopoldhsing.horizon.feign"})
@EntityScan("com.leopoldhsing.horizon.model")
@SpringBootApplication(scanBasePackages = "com.leopoldhsing.horizon")
public class BankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }
}
