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
    private String routingNumber;
    private String beneficiaryName;
    private UserDto sender;
    private UserDto receiver;
    private AccountDto senderAccount;
    private AccountDto receiverAccount;
    private LocalDate date;
    private LocalDateTime datetime;
    private LocalDate authorizedDate;
    private LocalDateTime authorizedDatetime;
    private TransactionStatus status;
    private CategoryDto category;
    private String channel;
    private String email;

    public TransactionDto() {
    }

    public TransactionDto(Long id, String name, BigDecimal amount, String currency, String routingNumber, String beneficiaryName, UserDto sender, UserDto receiver, AccountDto senderAccount, AccountDto receiverAccount, LocalDate date, LocalDateTime datetime, LocalDate authorizedDate, LocalDateTime authorizedDatetime, TransactionStatus status, CategoryDto category, String channel, String email) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.currency = currency;
        this.routingNumber = routingNumber;
        this.beneficiaryName = beneficiaryName;
        this.sender = sender;
        this.receiver = receiver;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.date = date;
        this.datetime = datetime;
        this.authorizedDate = authorizedDate;
        this.authorizedDatetime = authorizedDatetime;
        this.status = status;
        this.category = category;
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
                ", routingNumber='" + routingNumber + '\'' +
                ", beneficiaryName='" + beneficiaryName + '\'' +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", senderAccount=" + senderAccount +
                ", receiverAccount=" + receiverAccount +
                ", date=" + date +
                ", datetime=" + datetime +
                ", authorizedDate=" + authorizedDate +
                ", authorizedDatetime=" + authorizedDatetime +
                ", status=" + status +
                ", category=" + category +
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

    public AccountDto getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(AccountDto senderAccount) {
        this.senderAccount = senderAccount;
    }

    public AccountDto getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(AccountDto receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public LocalDate getAuthorizedDate() {
        return authorizedDate;
    }

    public void setAuthorizedDate(LocalDate authorizedDate) {
        this.authorizedDate = authorizedDate;
    }

    public LocalDateTime getAuthorizedDatetime() {
        return authorizedDatetime;
    }

    public void setAuthorizedDatetime(LocalDateTime authorizedDatetime) {
        this.authorizedDatetime = authorizedDatetime;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
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
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(amount, that.amount) && Objects.equals(currency, that.currency) && Objects.equals(routingNumber, that.routingNumber) && Objects.equals(beneficiaryName, that.beneficiaryName) && Objects.equals(sender, that.sender) && Objects.equals(receiver, that.receiver) && Objects.equals(senderAccount, that.senderAccount) && Objects.equals(receiverAccount, that.receiverAccount) && Objects.equals(date, that.date) && Objects.equals(datetime, that.datetime) && Objects.equals(authorizedDate, that.authorizedDate) && Objects.equals(authorizedDatetime, that.authorizedDatetime) && status == that.status && Objects.equals(category, that.category) && Objects.equals(channel, that.channel) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(amount);
        result = 31 * result + Objects.hashCode(currency);
        result = 31 * result + Objects.hashCode(routingNumber);
        result = 31 * result + Objects.hashCode(beneficiaryName);
        result = 31 * result + Objects.hashCode(sender);
        result = 31 * result + Objects.hashCode(receiver);
        result = 31 * result + Objects.hashCode(senderAccount);
        result = 31 * result + Objects.hashCode(receiverAccount);
        result = 31 * result + Objects.hashCode(date);
        result = 31 * result + Objects.hashCode(datetime);
        result = 31 * result + Objects.hashCode(authorizedDate);
        result = 31 * result + Objects.hashCode(authorizedDatetime);
        result = 31 * result + Objects.hashCode(status);
        result = 31 * result + Objects.hashCode(category);
        result = 31 * result + Objects.hashCode(channel);
        result = 31 * result + Objects.hashCode(email);
        return result;
    }
}
