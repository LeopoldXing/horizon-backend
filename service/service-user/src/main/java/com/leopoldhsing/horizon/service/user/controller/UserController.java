package com.leopoldhsing.horizon.service.user.controller;

import com.leopoldhsing.horizon.model.dto.GeneralResponseDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.vo.UserSignUpVo;
import com.leopoldhsing.horizon.service.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/sign-in")
    public ResponseEntity<GeneralResponseDto<UserDto>> userSignIn(@RequestBody String email, @RequestBody String password) {
        UserDto userDto = userService.userSignIn(email, password);

        return ResponseEntity.ok(new GeneralResponseDto<>(userDto));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<GeneralResponseDto<UserDto>> userSignUp(@RequestBody(required = false) UserSignUpVo userSignUpVo) {
        UserDto userDto = userService.userSignUp(userSignUpVo);

        System.out.println(userDto);
        return ResponseEntity.ok(new GeneralResponseDto<>(userDto));
    }
}
