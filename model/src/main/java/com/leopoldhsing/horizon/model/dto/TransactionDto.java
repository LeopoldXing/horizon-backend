package com.leopoldhsing.horizon.model.dto;

import com.leopoldhsing.horizon.model.enumeration.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionDto {

    private Long id;
    private String name;
    private BigDecimal amount;
    private String currency;
    private AccountDto accountDto;
    private String routingNumber;
    private String beneficiaryName;
    private UserDto sender;
    private UserDto receiver;
    private LocalDate date;
    private LocalDateTime dateTime;
    private LocalDate authorizedDate;
    private LocalDateTime authorizedDateTime;
    private TransactionStatus status;
    private BankDto senderBank;
    private CategoryDto category;
    private BankDto receiverBank;
    private String channel;
    private String email;

    public TransactionDto() {
    }

    public TransactionDto(Long id, String name, BigDecimal amount, String currency, AccountDto accountDto, String routingNumber, String beneficiaryName, UserDto sender, UserDto receiver, LocalDate date, LocalDateTime dateTime, LocalDate authorizedDate, LocalDateTime authorizedDateTime, TransactionStatus status, BankDto senderBank, CategoryDto category, BankDto receiverBank, String channel, String email) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.currency = currency;
        this.accountDto = accountDto;
        this.routingNumber = routingNumber;
        this.beneficiaryName = beneficiaryName;
        this.sender = sender;
        this.receiver = receiver;
        this.date = date;
        this.dateTime = dateTime;
        this.authorizedDate = authorizedDate;
        this.authorizedDateTime = authorizedDateTime;
        this.status = status;
        this.senderBank = senderBank;
        this.category = category;
        this.receiverBank = receiverBank;
        this.channel = channel;
        this.email = email;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", accountDto=" + accountDto +
                ", routingNumber='" + routingNumber + '\'' +
                ", beneficiaryName='" + beneficiaryName + '\'' +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", date=" + date +
                ", dateTime=" + dateTime +
                ", authorizedDate=" + authorizedDate +
                ", authorizedDateTime=" + authorizedDateTime +
                ", status=" + status +
                ", senderBank=" + senderBank +
                ", category=" + category +
                ", receiverBank=" + receiverBank +
                ", channel='" + channel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public UserDto getSender() {
        return sender;
    }

    public void setSender(UserDto sender) {
        this.sender = sender;
    }

    public UserDto getReceiver() {
        return receiver;
    }

    public void setReceiver(UserDto receiver) {
        this.receiver = receiver;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDate getAuthorizedDate() {
        return authorizedDate;
    }

    public void setAuthorizedDate(LocalDate authorizedDate) {
        this.authorizedDate = authorizedDate;
    }

    public LocalDateTime getAuthorizedDateTime() {
        return authorizedDateTime;
    }

    public void setAuthorizedDateTime(LocalDateTime authorizedDateTime) {
        this.authorizedDateTime = authorizedDateTime;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public BankDto getSenderBank() {
        return senderBank;
    }

    public void setSenderBank(BankDto senderBank) {
        this.senderBank = senderBank;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public BankDto getReceiverBank() {
        return receiverBank;
    }

    public void setReceiverBank(BankDto receiverBank) {
        this.receiverBank = receiverBank;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionDto that = (TransactionDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(amount, that.amount) && Objects.equals(currency, that.currency) && Objects.equals(accountDto, that.accountDto) && Objects.equals(routingNumber, that.routingNumber) && Objects.equals(beneficiaryName, that.beneficiaryName) && Objects.equals(sender, that.sender) && Objects.equals(receiver, that.receiver) && Objects.equals(date, that.date) && Objects.equals(dateTime, that.dateTime) && Objects.equals(authorizedDate, that.authorizedDate) && Objects.equals(authorizedDateTime, that.authorizedDateTime) && status == that.status && Objects.equals(senderBank, that.senderBank) && Objects.equals(category, that.category) && Objects.equals(receiverBank, that.receiverBank) && Objects.equals(channel, that.channel) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(amount);
        result = 31 * result + Objects.hashCode(currency);
        result = 31 * result + Objects.hashCode(accountDto);
        result = 31 * result + Objects.hashCode(routingNumber);
        result = 31 * result + Objects.hashCode(beneficiaryName);
        result = 31 * result + Objects.hashCode(sender);
        result = 31 * result + Objects.hashCode(receiver);
        result = 31 * result + Objects.hashCode(date);
        result = 31 * result + Objects.hashCode(dateTime);
        result = 31 * result + Objects.hashCode(authorizedDate);
        result = 31 * result + Objects.hashCode(authorizedDateTime);
        result = 31 * result + Objects.hashCode(status);
        result = 31 * result + Objects.hashCode(senderBank);
        result = 31 * result + Objects.hashCode(category);
        result = 31 * result + Objects.hashCode(receiverBank);
        result = 31 * result + Objects.hashCode(channel);
        result = 31 * result + Objects.hashCode(email);
        return result;
    }
}
