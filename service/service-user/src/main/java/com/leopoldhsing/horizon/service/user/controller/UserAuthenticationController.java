package com.leopoldhsing.horizon.service.user.controller;

import com.leopoldhsing.horizon.common.utils.Md5Util;
import com.leopoldhsing.horizon.model.dto.GeneralResponseDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.mapper.UserMapper;
import com.leopoldhsing.horizon.model.vo.UserResponseVo;
import com.leopoldhsing.horizon.model.vo.UserSignInResponseVo;
import com.leopoldhsing.horizon.model.vo.UserSignInVo;
import com.leopoldhsing.horizon.model.vo.UserSignUpVo;
import com.leopoldhsing.horizon.service.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserAuthenticationController {

    @Autowired
    private IUserService userService;

    @PostMapping("/sign-in")
    public ResponseEntity<GeneralResponseDto<UserSignInResponseVo>> userSignIn(@RequestBody UserSignInVo userSignInVo) {
        Map<String, Object> data = userService.userSignIn(userSignInVo.getEmail(), userSignInVo.getPassword());

        UserDto userDto = (UserDto) data.get("user");
        String token = (String) data.get("token");

        UserSignInResponseVo res = new UserSignInResponseVo(userDto, token);

        return ResponseEntity.ok(new GeneralResponseDto<>(res));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<GeneralResponseDto<UserResponseVo>> userSignUp(@RequestBody UserSignUpVo userSignUpVo) {
        userSignUpVo.setPassword(Md5Util.encrypt(userSignUpVo.getPassword()));
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
}
