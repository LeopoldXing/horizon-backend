package com.leopoldhsing.horizon.service.user.mapper;

import com.leopoldhsing.horizon.feign.dwolla.DwollaFeignClient;
import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper2 {

    @Autowired
    private DwollaFeignClient dwollaFeignClient;

    public UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        DwollaCustomerDto dwollaCustomerDto = dwollaFeignClient.getDwollaCustomerById(user.getDwollaCustomerId());
        userDto.setDwollaCustomerDto(dwollaCustomerDto);
        return userDto;
    }
}
