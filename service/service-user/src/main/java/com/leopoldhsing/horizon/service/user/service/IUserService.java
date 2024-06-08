package com.leopoldhsing.horizon.service.user.service;

import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.vo.UserSignUpVo;

import java.util.Map;

public interface IUserService {
    Map<String, Object> userSignIn(String email, String password);

    Map<String, Object> userSignUp(UserSignUpVo userSignUpVo);

    UserDto getUserById(Long uid);

    void initializeUser(Long userId);

    int countUserBankQuantity(Long userId);

    double getUserTotalBalance(Long userId);

    void userSignOut(String token);
}
