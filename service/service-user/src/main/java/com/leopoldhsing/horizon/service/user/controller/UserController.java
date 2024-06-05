package com.leopoldhsing.horizon.service.user.controller;

import com.leopoldhsing.horizon.common.utils.RequestUtil;
import com.leopoldhsing.horizon.common.utils.TokenUtil;
import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto;
import com.leopoldhsing.horizon.model.dto.GeneralResponseDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.vo.UserSignUpResponseVo;
import com.leopoldhsing.horizon.model.vo.UserSignUpVo;
import com.leopoldhsing.horizon.service.user.service.IUserService;
import org.springframework.beans.BeanUtils;
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
    public ResponseEntity<GeneralResponseDto<UserSignUpResponseVo>> userSignUp(@RequestBody UserSignUpVo userSignUpVo) {
        UserDto userDto = userService.userSignUp(userSignUpVo);
        DwollaCustomerDto dwollaCustomerDto = userDto.getDwollaCustomerDto();

        UserSignUpResponseVo responseVo = new UserSignUpResponseVo();

        BeanUtils.copyProperties(userDto, responseVo);
        responseVo.set$id(String.valueOf(userDto.getId()));
        responseVo.setUserId(String.valueOf(userDto.getId()));
        responseVo.setName(userDto.getFirstName() + " " + userDto.getLastName());
        responseVo.setAddress1(userDto.getAddress());
        responseVo.setDateOfBirth(userDto.getDateOfBirth().toString());
        responseVo.setDwollaCustomerUrl(dwollaCustomerDto == null ? "" : dwollaCustomerDto.getDwollaCustomerUrl());
        responseVo.setDwollaCustomerId(dwollaCustomerDto == null ? "" : String.valueOf(dwollaCustomerDto.getId()));

        // generate token
        String token = TokenUtil.generateToken();
        responseVo.setToken(token);

        System.out.println(responseVo);

        return ResponseEntity.ok(new GeneralResponseDto<>(responseVo));
    }

    @GetMapping
    public ResponseEntity<GeneralResponseDto<UserDto>> getUser() {
        // 1. get userId
        Long uid = RequestUtil.getUid();

        // 2. search user by id
        UserDto userDto = userService.getUserById(uid);

        return ResponseEntity.ok(new GeneralResponseDto<>(userDto));
    }
}
