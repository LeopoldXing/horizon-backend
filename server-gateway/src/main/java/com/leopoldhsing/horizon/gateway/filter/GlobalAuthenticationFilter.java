package com.leopoldhsing.horizon.gateway.filter;

import com.leopoldhsing.horizon.gateway.config.AuthConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class GlobalAuthenticationFilter implements GatewayFilter {

    @Autowired
    private AuthConfigurationProperties configurationProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        AntPathMatcher antPathMatcher = new AntPathMatcher();

        // 1. get request
        ServerHttpRequest request = exchange.getRequest();

        // 2. authentication
        // 2.1 get path
        String path = request.getURI().getPath();

        // 2.2 trusted uri pattern
        List<String> trustedUriList = configurationProperties.getTrustedUriPatterns();
        long staticResourcesCount = trustedUriList
                .parallelStream()
                .filter(pattern -> antPathMatcher.match(pattern, path))
                .count();
        if (staticResourcesCount > 0) {
            // trusted url will directly pass authentication
            return chain.filter(exchange);
        }

        // 2.3 inner call request
        List<String> innerUriList = configurationProperties.getInnerUriPatterns();
        long innerRequestCount = innerUriList
                .parallelStream()
                .filter(pattern -> antPathMatcher.match(pattern, path))
                .count();
        if (innerRequestCount > 0) {
            // inner request called externally will be blocked directly

        }


        return null;
    }

}
