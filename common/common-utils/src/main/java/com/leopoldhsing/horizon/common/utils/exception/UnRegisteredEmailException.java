package com.leopoldhsing.horizon.common.utils.exception;

public class UnRegisteredEmailException extends RuntimeException {
    public UnRegisteredEmailException(String email) {
        super("Email " + email + " was not registered.");
    }
}
