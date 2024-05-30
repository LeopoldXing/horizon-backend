package com.leopoldhsing.horizon.model.dto;

import org.springframework.http.HttpStatus;

import java.util.Objects;

public class GeneralResponseDto<T> {

    private Integer statusCode;
    private String message;
    private T data;

    public GeneralResponseDto() {
        statusCode = HttpStatus.OK.value();
        message = HttpStatus.OK.getReasonPhrase();
    }

    public GeneralResponseDto(T data) {
        this();
        this.data = data;
    }

    public GeneralResponseDto(Integer statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "GeneralResponseDto{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeneralResponseDto<?> that = (GeneralResponseDto<?>) o;
        return Objects.equals(statusCode, that.statusCode) && Objects.equals(message, that.message) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(statusCode);
        result = 31 * result + Objects.hashCode(message);
        result = 31 * result + Objects.hashCode(data);
        return result;
    }
}
