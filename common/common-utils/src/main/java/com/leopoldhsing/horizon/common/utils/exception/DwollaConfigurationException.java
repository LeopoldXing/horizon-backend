package com.leopoldhsing.horizon.common.utils.exception;

public class DwollaConfigurationException extends RuntimeException{
    public DwollaConfigurationException() {
        super("Dwolla's environment type not specified");
    }
}
