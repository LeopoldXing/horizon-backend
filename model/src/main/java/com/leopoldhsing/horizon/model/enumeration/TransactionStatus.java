package com.leopoldhsing.horizon.model.enumeration;

public enum TransactionStatus {
    PROCESSED("PROCESSED"),
    PENDING("PENDING"),
    CANCELLED("CANCELLED"),
    FAILED("FAILED");

    private final String value;

    TransactionStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
