package com.leopoldhsing.horizon.common.utils.exception;

public class ResourceNotAccessibleException extends RuntimeException {

    public ResourceNotAccessibleException(String resourceName, String path) {
        super(String.format("Accessing %s via %s is not authorized", resourceName, path));
    }
}
