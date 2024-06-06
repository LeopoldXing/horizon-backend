package com.leopoldhsing.horizon.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "banks")
@Entity
public class Bank extends BaseEntity {

    private String name;
    private String institutionId;
    private String url;
    private String status;

    public Bank() {
    }

    public Bank(Long id, LocalDateTime createdAt, LocalDateTime lastModifiedAt, String createdBy, String lastModifiedBy) {
        super(id, createdAt, lastModifiedAt, createdBy, lastModifiedBy);
    }

    public Bank(String name, String institutionId, String url, String status) {
        this.name = name;
        this.institutionId = institutionId;
        this.url = url;
        this.status = status;
    }

    public Bank(Long id, LocalDateTime createdAt, LocalDateTime lastModifiedAt, String createdBy, String lastModifiedBy, String name, String institutionId, String url, String status) {
        super(id, createdAt, lastModifiedAt, createdBy, lastModifiedBy);
        this.name = name;
        this.institutionId = institutionId;
        this.url = url;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", institutionId='" + institutionId + '\'' +
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

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
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
        return Objects.equals(name, bank.name) && Objects.equals(institutionId, bank.institutionId) && Objects.equals(url, bank.url) && Objects.equals(status, bank.status);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(institutionId);
        result = 31 * result + Objects.hashCode(url);
        result = 31 * result + Objects.hashCode(status);
        return result;
    }
}
