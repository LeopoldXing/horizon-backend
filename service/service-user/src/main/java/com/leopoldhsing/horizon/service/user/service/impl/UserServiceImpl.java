package com.leopoldhsing.horizon.service.user.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leopoldhsing.horizon.common.utils.Md5Util;
import com.leopoldhsing.horizon.common.utils.TokenUtil;
import com.leopoldhsing.horizon.common.utils.constants.RedisConstants;
import com.leopoldhsing.horizon.common.utils.exception.InvalidPasswordException;
import com.leopoldhsing.horizon.common.utils.exception.ResourceNotFoundException;
import com.leopoldhsing.horizon.common.utils.exception.UnRegisteredEmailException;
import com.leopoldhsing.horizon.feign.account.AccountFeignClient;
import com.leopoldhsing.horizon.feign.dwolla.DwollaFeignClient;
import com.leopoldhsing.horizon.feign.plaid.PlaidFeignClient;
import com.leopoldhsing.horizon.feign.transaction.TransactionFeignClient;
import com.leopoldhsing.horizon.model.dto.*;
import com.leopoldhsing.horizon.model.entity.User;
import com.leopoldhsing.horizon.model.enumeration.DwollaCustomerType;
import com.leopoldhsing.horizon.model.vo.DwollaCustomerCreationVo;
import com.leopoldhsing.horizon.model.vo.UserSignUpVo;
import com.leopoldhsing.horizon.service.user.mapper.UserMapper2;
import com.leopoldhsing.horizon.service.user.repository.UserRepository;
import com.leopoldhsing.horizon.service.user.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private PlaidFeignClient plaidFeignClient;

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Autowired
    private TransactionFeignClient transactionFeignClient;

    @Autowired
    private DwollaFeignClient dwollaFeignClient;

    @Autowired
    private UserMapper2 userMapper;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map<String, Object> userSignIn(String email, String password) {
        Long count = userRepository.countUsersByEmail(email);
        if (count <= 0) {
            throw new UnRegisteredEmailException(email);
        }
        User user = userRepository.findByEmailAndPassword(email, Md5Util.encrypt(password)).orElseThrow(
                () -> new InvalidPasswordException(email, password)
        );

        Map<String, Object> res = new HashMap<>();
        UserDto userDto = userMapper.mapToUserDto(user);
        res.put("user", userDto);
        String token = TokenUtil.generateToken();
        redisTemplate
                .opsForValue()
                .set(RedisConstants.USER_KEY_PREFIX + RedisConstants.USER_ID_KEY_SUFFIX + token,
                        String.valueOf(user.getId()));
        try {
            redisTemplate
                    .opsForValue()
                    .set(RedisConstants.USER_KEY_PREFIX + RedisConstants.USER_INFO_KEY_SUFFIX + token,
                            objectMapper.writeValueAsString(userDto));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        res.put("token", token);
        return res;
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
            e.printStackTrace();
        }

        // 2. create dwolla customer and get the dwollaCustomerId [RPC]
        DwollaCustomerCreationVo dwollaCustomerCreationVo = new DwollaCustomerCreationVo();
        BeanUtils.copyProperties(userSignUpVo, dwollaCustomerCreationVo);
        dwollaCustomerCreationVo.setType(DwollaCustomerType.PERSONAL_VERIFIED_CUSTOMER.toString());
        dwollaCustomerCreationVo.setAddress1(userSignUpVo.getAddress());
        DwollaCustomerDto dwollaCustomerDto = dwollaFeignClient.createDwollaCustomer(dwollaCustomerCreationVo,
                DwollaCustomerType.PERSONAL_VERIFIED_CUSTOMER);

        // 3. set dwollaCustomerId into the user object
        user.setDwollaCustomerId(dwollaCustomerDto.getId());

        // 4. store the new user into the database
        userRepository.save(user);

        // 5. convert user -> userDto
        UserDto userDto = userMapper.mapToUserDto(user);

        // 6. generate token and store token into redis
        String token = TokenUtil.generateToken();
        redisTemplate
                .opsForValue()
                .set(RedisConstants.USER_KEY_PREFIX + RedisConstants.USER_ID_KEY_SUFFIX + token,
                        String.valueOf(user.getId()));
        try {
            redisTemplate
                    .opsForValue()
                    .set(RedisConstants.USER_KEY_PREFIX + RedisConstants.USER_INFO_KEY_SUFFIX + token,
                            objectMapper.writeValueAsString(userDto));
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
        UserDto userDto = userMapper.mapToUserDto(user);
        return userDto;
    }

    @Transactional
    @Override
    public void initializeUser(Long userId) {
        // 1. get userDto
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", String.valueOf(userId))
        );
        UserDto userDto = userMapper.mapToUserDto(user);

        // 2. get and save plaid accounts [RPC]
        List<AccountDto> accountDtoList = plaidFeignClient.getAccountsFromPlaidByUserId(userDto.getId());
        // 2.1 check and insert bank information
        accountDtoList = accountFeignClient.alignAccountInfo(new AccountAlignmentDto(accountDtoList, userDto));
        /*accountDtoList = accountFeignClient.saveAccountList(accountDtoList);*/

        // 3. get and save plaid transaction [RPC]
        accountDtoList.forEach(account -> {
            String plaidAccountId = account.getPlaidAccountId();
            List<TransactionDto> transactionDtoList = plaidFeignClient.getTransactionsFromPlaidByPlaidAccountId(plaidAccountId);
            transactionFeignClient.saveTransactionList(transactionDtoList);
        });
    }

    @Override
    public int countUserBankQuantity(Long userId) {
        // 1. get all account under this user
        List<AccountDto> accountDtoList = accountFeignClient.getAccountsByUserId(userId);

        // 2. add all account's institution number into a set
        Set<Long> bankIdSet = new HashSet<>();
        accountDtoList.forEach(account -> bankIdSet.add(account.getInstitution().getId()));

        // 3. return set size
        return bankIdSet.size();
    }

    @Override
    public double getUserTotalBalance(Long userId) {
        // 1. get all account under this user
        List<AccountDto> accountDtoList = accountFeignClient.getAccountsByUserId(userId);

        // 2. count
        double totalBalance = accountDtoList
                .stream()
                .reduce(BigDecimal.valueOf(0),
                        (subTotal, nextAccount) -> subTotal.add(nextAccount.getAvailableBalance()),
                        BigDecimal::add)
                .doubleValue();

        // 3. return result
        return totalBalance;
    }

    @Override
    public void userSignOut(String token) {
        redisTemplate.delete(RedisConstants.USER_KEY_PREFIX + RedisConstants.USER_ID_KEY_SUFFIX + token);
        redisTemplate.delete(RedisConstants.USER_KEY_PREFIX + RedisConstants.USER_INFO_KEY_SUFFIX + token);
        plaidFeignClient.deleteAccessToken();
    }
}
