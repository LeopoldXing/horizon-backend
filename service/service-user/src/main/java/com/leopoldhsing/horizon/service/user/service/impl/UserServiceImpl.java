package com.leopoldhsing.horizon.service.user.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leopoldhsing.horizon.common.utils.TokenUtil;
import com.leopoldhsing.horizon.common.utils.constants.RedisConstants;
import com.leopoldhsing.horizon.common.utils.exception.ResourceNotFoundException;
import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.entity.User;
import com.leopoldhsing.horizon.model.mapper.UserMapper;
import com.leopoldhsing.horizon.model.vo.UserSignUpVo;
import com.leopoldhsing.horizon.service.user.repository.UserRepository;
import com.leopoldhsing.horizon.service.user.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public UserDto userSignIn(String email, String password) {
        return new UserDto();
    }

    @Override
    public Map<String, Object> userSignUp(UserSignUpVo userSignUpVo) {
        // 1. create new user
        User user = new User();
        BeanUtils.copyProperties(userSignUpVo, user);
        // 1.2 set dob
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            user.setDateOfBirth(sdf.parse(userSignUpVo.getDateOfBirth()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // 2. create dwolla customer and get the dwollaCustomerId [RPC]

        // 3. set dwollaCustomerId into the user object

        // 4. store the new user into the database
        userRepository.save(user);

        // 5. convert user -> userDto
        UserDto userDto = UserMapper.mapToUserDto(user);

        // 6. generate token and store token into redis
        String token = TokenUtil.generateToken();
        redisTemplate
                .opsForValue()
                .set(RedisConstants.USER_KEY_PREFIX + RedisConstants.USER_ID_KEY_SUFFIX + token, String.valueOf(user.getId()));
        try {
            redisTemplate
                    .opsForValue()
                    .set(RedisConstants.USER_KEY_PREFIX + RedisConstants.USER_INFO_KEY_SUFFIX + token, objectMapper.writeValueAsString(userDto));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        // 7. return result
        Map<String, Object> res = new HashMap<>();
        res.put("token", token);
        res.put("user", userDto);
        return res;
    }

    @Override
    public UserDto getUserById(Long uid) {
        User user = userRepository.findById(uid).orElseThrow(
                () -> new ResourceNotFoundException("User", "uid", String.valueOf(uid))
        );
        return UserMapper.mapToUserDto(user);
    }
}
