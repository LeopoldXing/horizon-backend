package com.leopoldhsing.horizon.service.plaid.service;

import java.io.IOException;

public interface IPlaidService {

    Boolean exchangePublicToken(String publicToken) throws IOException;

    void deleteAccessToken();
}
