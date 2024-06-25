package com.leopoldhsing.horizon.feign.user;

import com.leopoldhsing.horizon.model.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    @GetMapping("/api/v1/inner/user/{uid}")
    UserDto getUser(@PathVariable("uid") Long uid);

}
