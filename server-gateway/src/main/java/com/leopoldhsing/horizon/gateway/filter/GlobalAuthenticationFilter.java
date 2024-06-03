package com.leopoldhsing.horizon.gateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leopoldhsing.horizon.gateway.config.AuthConfigurationProperties;
import com.leopoldhsing.horizon.model.dto.ErrorResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class GlobalAuthenticationFilter implements GatewayFilter {

    @Autowired
    private AuthConfigurationProperties configurationProperties;

    private final ObjectMapper objectMapper = new ObjectMapper();

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
        long trustedPatternCount = trustedUriList
                .parallelStream()
                .filter(pattern -> antPathMatcher.match(pattern, path))
                .count();
        if (trustedPatternCount > 0) {
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
            ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                    request.getPath().toString(),
                    HttpStatus.UNAUTHORIZED,
                    "Request Denied, you are trying to access restricted resources!",
                    LocalDateTime.now()
            );
            // prepare response data
            byte[] errorResponseBytes;
            try {
                errorResponseBytes = objectMapper.writeValueAsString(errorResponseDto).getBytes(StandardCharsets.UTF_8);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            // get response
            ServerHttpResponse response = exchange.getResponse();
            // add proper response header
            DataBuffer wrap = response.bufferFactory().wrap(errorResponseBytes);
            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
            // reject request | send response
            return response.writeWith(Mono.just(wrap));
        }


        return null;
    }


}
