package com.leopoldhsing.horizon.service.user.service;

import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.vo.UserSignUpVo;

public interface IUserService {
    UserDto userSignIn(String email, String password);

    UserDto userSignUp(UserSignUpVo userSignUpVo);
}
