package com.leopoldhsing.horizon.service.user.controller;

import com.leopoldhsing.horizon.common.utils.RequestUtil;
import com.leopoldhsing.horizon.model.dto.GeneralResponseDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.mapper.UserMapper;
import com.leopoldhsing.horizon.model.vo.UserResponseVo;
import com.leopoldhsing.horizon.service.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService userService;

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

    @GetMapping("/init")
    public ResponseEntity<GeneralResponseDto<Void>> initializeUser() {
        Long userId = RequestUtil.getUid();
        userService.initializeUser(userId);
        return ResponseEntity.ok(new GeneralResponseDto<>());
    }

    @GetMapping("/bank-quantity")
    public ResponseEntity<GeneralResponseDto<Integer>> getBankQuantity() {
        Long userId = RequestUtil.getUid();
        int number = userService.countUserBankQuantity(userId);

        return ResponseEntity.ok(new GeneralResponseDto<>(number));
    }

    @GetMapping("/total-balance")
    public ResponseEntity<GeneralResponseDto<Double>> getTotalBalance() {
        Long userId = RequestUtil.getUid();
        double totalBalance = userService.getUserTotalBalance(userId);
        return ResponseEntity.ok(new GeneralResponseDto<>(totalBalance));
    }
}
