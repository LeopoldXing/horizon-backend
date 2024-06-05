package com.leopoldhsing.horizon.service.user.controller;

import com.leopoldhsing.horizon.common.utils.RequestUtil;
import com.leopoldhsing.horizon.model.dto.GeneralResponseDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.mapper.UserMapper;
import com.leopoldhsing.horizon.model.vo.UserResponseVo;
import com.leopoldhsing.horizon.model.vo.UserSignUpVo;
import com.leopoldhsing.horizon.service.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResponseEntity<GeneralResponseDto<UserResponseVo>> userSignUp(@RequestBody UserSignUpVo userSignUpVo) {
        Map<String, Object> map = userService.userSignUp(userSignUpVo);

        // get userDto
        UserDto userDto = (UserDto) map.get("user");

        // construct responseVo
        UserResponseVo responseVo = UserMapper.mapToUserResponseVo(userDto);

        // generate token
        String token = String.valueOf(map.get("token"));
        responseVo.setToken(token);

        return ResponseEntity.ok(new GeneralResponseDto<>(responseVo));
    }

    @GetMapping
    public ResponseEntity<GeneralResponseDto<UserResponseVo>> getUser() {
        // 1. get userId
        Long uid = RequestUtil.getUid();

        // 2. search user by id
        UserDto userDto = userService.getUserById(uid);

        // 3. construct responseVo
        UserResponseVo responseVo = UserMapper.mapToUserResponseVo(userDto);

        return ResponseEntity.ok(new GeneralResponseDto<>(responseVo));
    }
}
