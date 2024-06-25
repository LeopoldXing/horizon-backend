package com.leopoldhsing.horizon.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/transaction")
    public Mono<String> transactionServiceFallback() {
        return Mono.just("Transaction service is currently unavailable. Please try again later.");
    }

    @GetMapping("/bank")
    public Mono<String> bankServiceFallback() {
        return Mono.just("Bank service is currently unavailable. Please try again later.");
    }

    @GetMapping("/dwolla")
    public Mono<String> dwollaServiceFallback() {
        return Mono.just("Dwolla service is currently unavailable. Please try again later.");
    }

    @GetMapping("/plaid")
    public Mono<String> plaidServiceFallback() {
        return Mono.just("Plaid service is currently unavailable. Please try again later.");
    }

    @GetMapping("/user")
    public Mono<String> userServiceFallback() {
        return Mono.just("User service is currently unavailable. Please try again later.");
    }

    @GetMapping("/account")
    public Mono<String> accountServiceFallback() {
        return Mono.just("Account service is currently unavailable. Please try again later.");
    }
}
