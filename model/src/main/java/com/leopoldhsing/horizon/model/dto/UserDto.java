package com.leopoldhsing.horizon.model.dto;

import java.util.Date;
import java.util.Objects;

public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private Date dateOfBirth;
    private String ssn;
    private DwollaCustomerDto dwollaCustomerDto;
    private PlaidCustomerDto plaidCustomerDto;

    public UserDto() {
    }

    public UserDto(Long id, String firstName, String lastName, String email, String address, String city, String state, String postalCode, Date dateOfBirth, String ssn, DwollaCustomerDto dwollaCustomerDto, PlaidCustomerDto plaidCustomerDto) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.dateOfBirth = dateOfBirth;
        this.ssn = ssn;
        this.dwollaCustomerDto = dwollaCustomerDto;
        this.plaidCustomerDto = plaidCustomerDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public DwollaCustomerDto getDwollaCustomerDto() {
        return dwollaCustomerDto;
    }

    public void setDwollaCustomerDto(DwollaCustomerDto dwollaCustomerDto) {
        this.dwollaCustomerDto = dwollaCustomerDto;
    }

    public PlaidCustomerDto getPlaidCustomerDto() {
        return plaidCustomerDto;
    }

    public void setPlaidCustomerDto(PlaidCustomerDto plaidCustomerDto) {
        this.plaidCustomerDto = plaidCustomerDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) && Objects.equals(firstName, userDto.firstName) && Objects.equals(lastName, userDto.lastName) && Objects.equals(email, userDto.email) && Objects.equals(address, userDto.address) && Objects.equals(city, userDto.city) && Objects.equals(state, userDto.state) && Objects.equals(postalCode, userDto.postalCode) && Objects.equals(dateOfBirth, userDto.dateOfBirth) && Objects.equals(ssn, userDto.ssn) && Objects.equals(dwollaCustomerDto, userDto.dwollaCustomerDto) && Objects.equals(plaidCustomerDto, userDto.plaidCustomerDto);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(firstName);
        result = 31 * result + Objects.hashCode(lastName);
        result = 31 * result + Objects.hashCode(email);
        result = 31 * result + Objects.hashCode(address);
        result = 31 * result + Objects.hashCode(city);
        result = 31 * result + Objects.hashCode(state);
        result = 31 * result + Objects.hashCode(postalCode);
        result = 31 * result + Objects.hashCode(dateOfBirth);
        result = 31 * result + Objects.hashCode(ssn);
        result = 31 * result + Objects.hashCode(dwollaCustomerDto);
        result = 31 * result + Objects.hashCode(plaidCustomerDto);
        return result;
    }
}
