package com.leopoldhsing.horizon.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Table(name = "users")
@Entity
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private Date dateOfBirth;
    private String ssn;
    private Long dwollaCustomerId;

    public User() {
    }

    public User(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
    }

    public User(String firstName, String lastName, String email, String address, String city, String state, String postalCode, Date dateOfBirth, String ssn, Long dwollaCustomerId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.dateOfBirth = dateOfBirth;
        this.ssn = ssn;
        this.dwollaCustomerId = dwollaCustomerId;
    }

    public User(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy, String firstName, String lastName, String email, String address, String city, String state, String postalCode, Date dateOfBirth, String ssn, Long dwollaCustomerId) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.dateOfBirth = dateOfBirth;
        this.ssn = ssn;
        this.dwollaCustomerId = dwollaCustomerId;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", ssn='" + ssn + '\'' +
                ", dwollaCustomerId=" + dwollaCustomerId +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Long getDwollaCustomerId() {
        return dwollaCustomerId;
    }

    public void setDwollaCustomerId(Long dwollaCustomerId) {
        this.dwollaCustomerId = dwollaCustomerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;
        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(address, user.address) && Objects.equals(city, user.city) && Objects.equals(state, user.state) && Objects.equals(postalCode, user.postalCode) && Objects.equals(dateOfBirth, user.dateOfBirth) && Objects.equals(ssn, user.ssn) && Objects.equals(dwollaCustomerId, user.dwollaCustomerId);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(firstName);
        result = 31 * result + Objects.hashCode(lastName);
        result = 31 * result + Objects.hashCode(email);
        result = 31 * result + Objects.hashCode(address);
        result = 31 * result + Objects.hashCode(city);
        result = 31 * result + Objects.hashCode(state);
        result = 31 * result + Objects.hashCode(postalCode);
        result = 31 * result + Objects.hashCode(dateOfBirth);
        result = 31 * result + Objects.hashCode(ssn);
        result = 31 * result + Objects.hashCode(dwollaCustomerId);
        return result;
    }
}
