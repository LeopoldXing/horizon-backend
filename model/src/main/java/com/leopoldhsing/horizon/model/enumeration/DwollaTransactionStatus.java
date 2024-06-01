package com.leopoldhsing.horizon.model.enumeration;

public enum DwollaTransactionStatus {
    PROCESSED(1),
    PENDING(2),
    CANCELLED(3),
    FAILED(4);

    private final int statusCode;

    DwollaTransactionStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "DwollaTransactionStatus{" +
                "statusCode=" + statusCode +
                '}';
    }
}
