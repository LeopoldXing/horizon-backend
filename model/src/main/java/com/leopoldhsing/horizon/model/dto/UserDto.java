package com.leopoldhsing.horizon.model.dto;

import java.util.Objects;

public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String postalCode;
    private String dateOfBirth;
    private String ssn;
    private String state;
    private DwollaCustomerDto dwollaCustomerDto;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String email, String address, String city, String postalCode, String dateOfBirth, String ssn, String state, DwollaCustomerDto dwollaCustomerDto) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.dateOfBirth = dateOfBirth;
        this.ssn = ssn;
        this.state = state;
        this.dwollaCustomerDto = dwollaCustomerDto;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", ssn='" + ssn + '\'' +
                ", state='" + state + '\'' +
                ", dwollaCustomerDto=" + dwollaCustomerDto +
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public DwollaCustomerDto getDwollaCustomerDto() {
        return dwollaCustomerDto;
    }

    public void setDwollaCustomerDto(DwollaCustomerDto dwollaCustomerDto) {
        this.dwollaCustomerDto = dwollaCustomerDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;
        return Objects.equals(firstName, userDto.firstName) && Objects.equals(lastName, userDto.lastName) && Objects.equals(email, userDto.email) && Objects.equals(address, userDto.address) && Objects.equals(city, userDto.city) && Objects.equals(postalCode, userDto.postalCode) && Objects.equals(dateOfBirth, userDto.dateOfBirth) && Objects.equals(ssn, userDto.ssn) && Objects.equals(state, userDto.state) && Objects.equals(dwollaCustomerDto, userDto.dwollaCustomerDto);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(firstName);
        result = 31 * result + Objects.hashCode(lastName);
        result = 31 * result + Objects.hashCode(email);
        result = 31 * result + Objects.hashCode(address);
        result = 31 * result + Objects.hashCode(city);
        result = 31 * result + Objects.hashCode(postalCode);
        result = 31 * result + Objects.hashCode(dateOfBirth);
        result = 31 * result + Objects.hashCode(ssn);
        result = 31 * result + Objects.hashCode(state);
        result = 31 * result + Objects.hashCode(dwollaCustomerDto);
        return result;
    }
}
