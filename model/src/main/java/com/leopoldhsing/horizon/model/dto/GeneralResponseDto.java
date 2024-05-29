package com.leopoldhsing.horizon.model.dto;

import java.util.Objects;

public class GeneralResponseDto {

    private String statusCode;

    private String statusMessage;

    public GeneralResponseDto() {
    }

    public GeneralResponseDto(String statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    @Override
    public String toString() {
        return "GeneralResponseDto{" +
                "statusCode='" + statusCode + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                '}';
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeneralResponseDto that = (GeneralResponseDto) o;
        return Objects.equals(statusCode, that.statusCode) && Objects.equals(statusMessage, that.statusMessage);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(statusCode);
        result = 31 * result + Objects.hashCode(statusMessage);
        return result;
    }
}
