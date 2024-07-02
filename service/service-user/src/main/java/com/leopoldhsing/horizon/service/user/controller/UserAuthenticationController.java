package com.leopoldhsing.horizon.service.user.controller;

import com.leopoldhsing.horizon.common.utils.Md5Util;
import com.leopoldhsing.horizon.common.utils.constants.GatewayConstants;
import com.leopoldhsing.horizon.model.dto.GeneralResponseDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.mapper.UserMapper;
import com.leopoldhsing.horizon.model.vo.UserResponseVo;
import com.leopoldhsing.horizon.model.vo.UserSignInResponseVo;
import com.leopoldhsing.horizon.model.vo.UserSignInVo;
import com.leopoldhsing.horizon.model.vo.UserSignUpVo;
import com.leopoldhsing.horizon.service.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserAuthenticationController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;

    @PostMapping("/sign-in")
    public ResponseEntity<GeneralResponseDto<UserSignInResponseVo>> userSignIn(@RequestBody UserSignInVo userSignInVo) {
        logger.debug("User sign in request received, with the following information: email: {}, password: {}",
                userSignInVo.getEmail(), userSignInVo.getPassword());

        Map<String, Object> data = userService.userSignIn(userSignInVo.getEmail(), userSignInVo.getPassword());

        UserDto userDto = (UserDto) data.get("user");
        String token = (String) data.get("token");

        UserSignInResponseVo res = new UserSignInResponseVo(userDto, token);

        logger.info("User sign in successful, username: {}, timestamp: {}", userDto.getFirstName(), new Date().getTime());

        return ResponseEntity.ok(new GeneralResponseDto<>(res));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<GeneralResponseDto<UserResponseVo>> userSignUp(@RequestBody UserSignUpVo userSignUpVo) {
        logger.debug("User sign up request received. Firstname: {}, email: {}, full info: {}",
                userSignUpVo.getFirstName(), userSignUpVo.getEmail(), userSignUpVo);

        userSignUpVo.setPassword(Md5Util.encrypt(userSignUpVo.getPassword()));
        Map<String, Object> map = userService.userSignUp(userSignUpVo);

        // get userDto
        UserDto userDto = (UserDto) map.get("user");

        logger.debug("User created successfully, id: {}", userDto.getId());

        // construct responseVo
        UserResponseVo responseVo = UserMapper.mapToUserResponseVo(userDto);

        // generate token
        String token = String.valueOf(map.get("token"));
        responseVo.setToken(token);
        logger.debug("User token generated: {}", token);
        logger.info("User registered successfully, username: {}", userDto.getFirstName());

        return ResponseEntity.ok(new GeneralResponseDto<>(responseVo));
    }

    @PostMapping("/sign-out")
    public ResponseEntity<GeneralResponseDto<Boolean>> userSignOut(@RequestHeader(GatewayConstants.TOKEN_HEADER_KEY) String token) {
        userService.userSignOut(token);
        return ResponseEntity.ok(new GeneralResponseDto<>(true));
    }
}
