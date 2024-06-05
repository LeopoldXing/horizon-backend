package com.leopoldhsing.horizon.common.utils.exception;

public class ResourcesNotAccessibleException extends RuntimeException {

    public ResourcesNotAccessibleException(String resourceName, String path) {
        super(String.format("Accessing %s via %s is not authorized", resourceName, path));
    }
}
