package com.leopoldhsing.horizon.feign.user;

import com.leopoldhsing.horizon.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback implements UserFeignClient{

    @Override
    public UserDto getUser(Long uid) {
        return null;
    }
}
