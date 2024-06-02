package com.leopoldhsing.horizon.common.utils.exception.plaid;

public class PublicTokenInvalidException extends RuntimeException {

    public PublicTokenInvalidException(String publicToken) {
        super("Can not exchange invalid public token: " + publicToken);
    }
}