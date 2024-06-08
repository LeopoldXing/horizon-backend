package com.leopoldhsing.horizon.common.utils.exception;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String email, String invalidPassword) {
        super("Invalid password: " + invalidPassword + " for email: " + email);
    }
}
