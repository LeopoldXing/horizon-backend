package com.leopoldhsing.horizon.service.user.api;

import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.service.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inner/user")
public class UserFeignApi {

    @Autowired
    private IUserService userService;

    @GetMapping("/{uid}")
    public UserDto getUser(@PathVariable("uid") Long uid) {
        return userService.getUserById(uid);
    }

}
