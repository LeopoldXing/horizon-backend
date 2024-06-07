package com.leopoldhsing.horizon.common.utils.exception;

public class ActionNotAuthorizedException extends RuntimeException {
    public ActionNotAuthorizedException(String actionName, Long userId) {
        super("User '" + userId + "' does not have permission to perform action '" + actionName + "'");
    }
}
