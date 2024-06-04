package com.leopoldhsing.horizon.gateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leopoldhsing.horizon.common.utils.constants.GatewayConstants;
import com.leopoldhsing.horizon.common.utils.constants.RedisConstants;
import com.leopoldhsing.horizon.gateway.config.AuthConfigurationProperties;
import com.leopoldhsing.horizon.model.dto.ErrorResponseDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

@Order(2)
@Component
public class GlobalAuthenticationFilter implements GlobalFilter {

    @Autowired
    private AuthConfigurationProperties configurationProperties;

    @Autowired
    private StringRedisTemplate redisTemplate;

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

        // 2.4 requests that needed to be accessed after signing in
        List<String> requireAuthUriPatterns = configurationProperties.getRequireAuthUriPatterns();
        if (!CollectionUtils.isEmpty(requireAuthUriPatterns)) {
            long requiredAuthUriCounts = requireAuthUriPatterns
                    .parallelStream()
                    .filter(pattern -> antPathMatcher.match(pattern, path))
                    .count();
            if (requiredAuthUriCounts > 0) {
                // justify if currently in login state
                String token = this.getTokenFromRequest(exchange);
                if (StringUtils.hasLength(token) || !this.tokenExistsInRedis(token)) {
                    // currently not logged in || token is not valid
                    return redirectPage(exchange, configurationProperties.getLoginPath());
                }
            }
        }

        // 3. processing regular request
        UserDto userDto = null;
        // 3.1 authenticate existing token inside the request
        String token = this.getTokenFromRequest(exchange);
        if (!StringUtils.hasLength(token) && !this.tokenExistsInRedis(token)) {
            // token exists but not valid
            return redirectPage(exchange, configurationProperties.getLoginPath());
        } else if (!StringUtils.hasLength(token)) {
            // token exists and is valid
            userDto = getUserDtoByToken(token);
            if (!ObjectUtils.isEmpty(userDto)) {
                // obtain current ip address and the ip address when logging in
                /*String loginIp =
                String currentIp =
                if (!StringUtils.hasLength(loginIp)) {
                    if (!loginIp.equalsIgnoreCase(currentIp)) {
                        // token is valid, but ip address is different
                        return redirectPage(exchange, configurationProperties.getLoginPath());
                    }
                } else {
                    // ip address when logging in is null
                    return redirectPage(exchange, configurationProperties.getLoginPath());
                }*/
            } else {
                // can not find user information according to the token
                return redirectPage(exchange, configurationProperties.getLoginPath());
            }
        }

        return userIdPenetration(exchange, chain, 1L);
    }

    /**
     * get user info from redis
     *
     * @param token
     * @return
     */
    private UserDto getUserDtoByToken(String token) {
        UserDto userDto = null;
        if (!StringUtils.hasLength(token)) {
            String key = RedisConstants.USER_KEY_PREFIX + RedisConstants.USER_INFO_KEY_SUFFIX + token;
            String userDtoJson = redisTemplate.opsForValue().get(key);
            if (!StringUtils.hasLength(userDtoJson)) {
                try {
                    userDto = objectMapper.readValue(userDtoJson, UserDto.class);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
        return userDto;
    }

    /**
     * redirect to designated path
     *
     * @param exchange
     * @param destination
     * @return
     */
    private Mono<Void> redirectPage(ServerWebExchange exchange, String destination) {
        // 1. determine if the target path is valid
        if (!StringUtils.hasLength(destination)) {
            // destination is not valid, redirect to login page
            destination = configurationProperties.getLoginPath();
        }

        // 2. get response
        ServerHttpResponse response = exchange.getResponse();

        // 3. set http properties
        response.setStatusCode(HttpStatus.FOUND);
        String path = "";
        ServerHttpRequest request = exchange.getRequest();
        try {
            path = request.getURI().toURL().toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // 4. set original url to the headers
        String url = destination + "?originUrl=" + path;
        response.getHeaders().add("Location", url);

        // 5. if redirect to login page, then delete existing horizon-token
        if (destination.equalsIgnoreCase(configurationProperties.getLoginPath())) {
            ResponseCookie tokenCookie = ResponseCookie.from("horizon-token", "")
                    .path("/")
                    .maxAge(0)
                    .build();
            response.addCookie(tokenCookie);
        }

        return response.setComplete();
    }

    /**
     * get token from request header
     *
     * @param exchange
     * @return
     */
    private String getTokenFromRequest(ServerWebExchange exchange) {
        // 1. get request
        ServerHttpRequest request = exchange.getRequest();

        // 2. get Authorization header
        String authHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        // 3. get token
        String token = "";
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
        }

        // 4. return token;
        return token;
    }

    /**
     * determine if the token exists in redis server
     *
     * @param token
     * @return
     */
    private Boolean tokenExistsInRedis(String token) {
        String key = RedisConstants.USER_KEY_PREFIX + RedisConstants.USER_INFO_KEY_SUFFIX + token;
        return redisTemplate.hasKey(key);
    }

    /**
     * pass userId to other microservices
     *
     * @param exchange
     * @param chain
     * @param userId
     * @return
     */
    private Mono<Void> userIdPenetration(ServerWebExchange exchange, GatewayFilterChain chain, Long userId) {
        // 1. get request and response
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        // 2. add userId to the request
        ServerHttpRequest newRequest = request.mutate().header(GatewayConstants.USERID_HEADER_KEY, String.valueOf(userId)).build();
        ServerWebExchange newExchange = exchange.mutate().request(newRequest).response(response).build();

        return chain.filter(newExchange);
    }
}
