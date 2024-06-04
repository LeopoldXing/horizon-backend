package com.leopoldhsing.horizon.common.utils.exception;

public class PlaidPublicTokenInvalidException extends RuntimeException {

    public PlaidPublicTokenInvalidException(String publicToken) {
        super("Can not exchange invalid public token: " + publicToken);
    }
}
