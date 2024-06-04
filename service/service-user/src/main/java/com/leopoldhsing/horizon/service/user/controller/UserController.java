package com.leopoldhsing.horizon.service.user.controller;

import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto;
import com.leopoldhsing.horizon.model.dto.GeneralResponseDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.vo.UserSignUpVo;
import com.leopoldhsing.horizon.service.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public ResponseEntity<GeneralResponseDto<Map<String, String>>> userSignUp(@RequestBody(required = false) UserSignUpVo userSignUpVo) {
        UserDto userDto = userService.userSignUp(userSignUpVo);
        DwollaCustomerDto dwollaCustomerDto = userDto.getDwollaCustomerDto();

        Map<String, String> res = new HashMap<>();
        res.put("$id", String.valueOf(userDto.getId()));
        res.put("userId", String.valueOf(userDto.getId()));
        res.put("name", userDto.getFirstName() + " " + userDto.getLastName());
        res.put("firstName", userDto.getFirstName());
        res.put("lastName", userDto.getLastName());
        res.put("email", userDto.getEmail());
        res.put("address1", userDto.getAddress());
        res.put("city", userDto.getCity());
        res.put("state", userDto.getState());
        res.put("postalCode", userDto.getPostalCode());
        res.put("dateOfBirth", userDto.getDateOfBirth().toString());
        res.put("ssn", userDto.getSsn());
        /*  dwolla  */
        res.put("dwollaCustomerUrl", dwollaCustomerDto == null ? "" : dwollaCustomerDto.getDwollaCustomerUrl());
        res.put("dwollaCustomerId", dwollaCustomerDto == null ? "" : String.valueOf(dwollaCustomerDto.getId()));

        System.out.println(res);

        return ResponseEntity.ok(new GeneralResponseDto<>(res));
    }
}
