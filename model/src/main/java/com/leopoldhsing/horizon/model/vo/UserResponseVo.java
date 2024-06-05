package com.leopoldhsing.horizon.model.vo;

import java.util.Objects;

public class UserResponseVo {
    private String $id;
    private String userId;
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    private String address1;
    private String city;
    private String state;
    private String postalCode;
    private String dateOfBirth;
    private String ssn;
    private String dwollaCustomerUrl;
    private String dwollaCustomerId;
    private String token;

    public UserResponseVo() {
    }

    public UserResponseVo(String $id, String userId, String name, String firstName, String lastName, String email, String address1, String city, String state, String postalCode, String dateOfBirth, String ssn, String dwollaCustomerUrl, String dwollaCustomerId, String token) {
        this.$id = $id;
        this.userId = userId;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address1 = address1;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.dateOfBirth = dateOfBirth;
        this.ssn = ssn;
        this.dwollaCustomerUrl = dwollaCustomerUrl;
        this.dwollaCustomerId = dwollaCustomerId;
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserSignUpResponseVo{" +
                "$id='" + $id + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address1='" + address1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", ssn='" + ssn + '\'' +
                ", dwollaCustomerUrl='" + dwollaCustomerUrl + '\'' +
                ", dwollaCustomerId='" + dwollaCustomerId + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getDwollaCustomerUrl() {
        return dwollaCustomerUrl;
    }

    public void setDwollaCustomerUrl(String dwollaCustomerUrl) {
        this.dwollaCustomerUrl = dwollaCustomerUrl;
    }

    public String getDwollaCustomerId() {
        return dwollaCustomerId;
    }

    public void setDwollaCustomerId(String dwollaCustomerId) {
        this.dwollaCustomerId = dwollaCustomerId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserResponseVo that = (UserResponseVo) o;
        return Objects.equals($id, that.$id) && Objects.equals(userId, that.userId) && Objects.equals(name, that.name) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email) && Objects.equals(address1, that.address1) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(postalCode, that.postalCode) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(ssn, that.ssn) && Objects.equals(dwollaCustomerUrl, that.dwollaCustomerUrl) && Objects.equals(dwollaCustomerId, that.dwollaCustomerId) && Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode($id);
        result = 31 * result + Objects.hashCode(userId);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(firstName);
        result = 31 * result + Objects.hashCode(lastName);
        result = 31 * result + Objects.hashCode(email);
        result = 31 * result + Objects.hashCode(address1);
        result = 31 * result + Objects.hashCode(city);
        result = 31 * result + Objects.hashCode(state);
        result = 31 * result + Objects.hashCode(postalCode);
        result = 31 * result + Objects.hashCode(dateOfBirth);
        result = 31 * result + Objects.hashCode(ssn);
        result = 31 * result + Objects.hashCode(dwollaCustomerUrl);
        result = 31 * result + Objects.hashCode(dwollaCustomerId);
        result = 31 * result + Objects.hashCode(token);
        return result;
    }
}
