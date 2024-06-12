package com.leopoldhsing.horizon.service.plaid.service;

import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.UserDto;

import java.io.IOException;

public interface IPlaidService {

    Boolean exchangePublicToken(String publicToken) throws IOException;

    void deleteAccessToken();

    String getProcessorToken(UserDto userDto, AccountDto accountDto) throws IOException;
}
