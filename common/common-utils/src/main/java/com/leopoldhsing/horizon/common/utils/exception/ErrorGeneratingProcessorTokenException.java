package com.leopoldhsing.horizon.common.utils.exception;

public class ErrorGeneratingProcessorTokenException extends RuntimeException {
    public ErrorGeneratingProcessorTokenException(String clientId, String publicToken) {
        super("Error generating processor token, clientId: " + clientId + ", publicToken:" + publicToken);
    }
}
