package com.leopoldhsing.horizon.model.entity;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Bank extends BaseEntity {

    private String name;
    private String url;
    private String status;

    public Bank() {
    }

    public Bank(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
    }

    public Bank(String name, String url, String status) {
        this.name = name;
        this.url = url;
        this.status = status;
    }

    public Bank(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy, String name, String url, String status) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
        this.name = name;
        this.url = url;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.equals(url, bank.url) && Objects.equals(status, bank.status);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(url);
        result = 31 * result + Objects.hashCode(status);
        return result;
    }
}
