package com.leopoldhsing.horizon.model.mapper;

import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.entity.User;
import org.springframework.beans.BeanUtils;

public class UserMapper {

    private UserMapper() {
    }

    public static User mapToUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }

    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
}
