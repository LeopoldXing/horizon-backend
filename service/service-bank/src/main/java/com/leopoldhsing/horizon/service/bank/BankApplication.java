package com.leopoldhsing.horizon.service.bank;

import com.leopoldhsing.horizon.feign.account.AccountFeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(clients = {AccountFeignClient.class})
@EntityScan("com.leopoldhsing.horizon.model")
@SpringBootApplication
public class BankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }
}
