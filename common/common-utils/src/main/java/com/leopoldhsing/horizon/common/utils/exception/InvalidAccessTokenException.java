package com.leopoldhsing.horizon.common.utils.exception;

public class InvalidAccessTokenException extends RuntimeException{
    public InvalidAccessTokenException(String accessToken) {
        super("Invalid access token: " + accessToken);
    }
}
