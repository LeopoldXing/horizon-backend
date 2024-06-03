package com.leopoldhsing.horizon.common.utils.exception;

public class ResourcesNotAccessible extends RuntimeException {

    public ResourcesNotAccessible(String resourceName, String path) {
        super(String.format("Accessing %s via %s is not authorized", resourceName, path));
    }
}
