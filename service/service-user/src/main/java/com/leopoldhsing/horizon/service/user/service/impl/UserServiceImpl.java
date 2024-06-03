package com.leopoldhsing.horizon.service.user.service.impl;

import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.entity.User;
import com.leopoldhsing.horizon.model.mapper.UserMapper;
import com.leopoldhsing.horizon.model.vo.UserSignUpVo;
import com.leopoldhsing.horizon.service.user.repository.UserRepository;
import com.leopoldhsing.horizon.service.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto userSignIn(String email, String password) {
        return new UserDto();
    }

    @Override
    public UserDto userSignUp(UserSignUpVo userSignUpVo) {
        // 1. create new user
        User user = new User();

        // 2. create dwolla customer and get the dwollaCustomerId

        // 3. set dwollaCustomerId into the user object

        // 4. store the new user into the database
        userRepository.save(user);

        // 5. convert user -> userDto, return userDto
        return UserMapper.mapToUserDto(user);
    }
}
