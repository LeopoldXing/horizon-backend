package com.leopoldhsing.horizon.model.vo;

import java.util.Objects;

public class UserSignUpVo {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String dateOfBirth;
    private String ssn;
    private String email;
    private String password;

    public UserSignUpVo() {
    }

    public UserSignUpVo(String firstName, String lastName, String address, String city, String state, String postalCode, String dateOfBirth, String ssn, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.dateOfBirth = dateOfBirth;
        this.ssn = ssn;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserSignUpVo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", ssn='" + ssn + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSignUpVo that = (UserSignUpVo) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(postalCode, that.postalCode) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(ssn, that.ssn) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(firstName);
        result = 31 * result + Objects.hashCode(lastName);
        result = 31 * result + Objects.hashCode(address);
        result = 31 * result + Objects.hashCode(city);
        result = 31 * result + Objects.hashCode(state);
        result = 31 * result + Objects.hashCode(postalCode);
        result = 31 * result + Objects.hashCode(dateOfBirth);
        result = 31 * result + Objects.hashCode(ssn);
        result = 31 * result + Objects.hashCode(email);
        result = 31 * result + Objects.hashCode(password);
        return result;
    }
}
