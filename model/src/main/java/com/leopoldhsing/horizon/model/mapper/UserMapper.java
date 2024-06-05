package com.leopoldhsing.horizon.model.mapper;

import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.entity.User;
import com.leopoldhsing.horizon.model.vo.UserResponseVo;
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

    public static UserResponseVo mapToUserResponseVo(UserDto userDto) {
        UserResponseVo responseVo = new UserResponseVo();
        DwollaCustomerDto dwollaCustomerDto = userDto.getDwollaCustomerDto();
        BeanUtils.copyProperties(userDto, responseVo);
        responseVo.set$id(String.valueOf(userDto.getId()));
        responseVo.setUserId(String.valueOf(userDto.getId()));
        responseVo.setName(userDto.getFirstName() + " " + userDto.getLastName());
        responseVo.setAddress1(userDto.getAddress());
        responseVo.setDateOfBirth(userDto.getDateOfBirth().toString());
        responseVo.setDwollaCustomerUrl(dwollaCustomerDto == null ? "" : dwollaCustomerDto.getDwollaCustomerUrl());
        responseVo.setDwollaCustomerId(dwollaCustomerDto == null ? "" : String.valueOf(dwollaCustomerDto.getId()));

        return responseVo;
    }
}
