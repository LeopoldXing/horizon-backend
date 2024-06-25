package com.leopoldhsing.horizon.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    /**
     * set default global redis rate limiter configuration
     *
     * @return
     */
    @Bean(name = "defaultRateLimiter")
    public RedisRateLimiter redisRateLimiter() {
        return new RedisRateLimiter(100, 200, 1);
    }

    /**
     * set global redis rate limiter configuration - key resolver
     *
     * @return
     */
    @Bean
    KeyResolver userKeyResolver() {
        return exchange -> {
            // 1. get request
            ServerHttpRequest request = exchange.getRequest();

            // 2. get Authorization header
            String authHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

            // 3. get token
            String token = "";
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                token = authHeader.substring(7);
            }

            // 4. determine if token exists, if not, return "unknown"
            if (!StringUtils.hasLength(token) || !StringUtils.hasText(token)) {
                token = "unkown";
            }

            return Mono.just(token);
        };
    }
}
