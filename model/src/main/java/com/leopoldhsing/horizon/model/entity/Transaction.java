package com.leopoldhsing.horizon.model.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Transaction extends BaseEntity {

    private String name;
    private BigDecimal amount;
    private String currency;
    private String routingNumber;
    private String beneficiaryName;
    private Long senderId;
    private Long receiverId;
    private LocalDate date;
    private LocalDateTime dateTime;
    private LocalDate authorizedDate;
    private LocalDateTime authorizedDateTime;
    private String status;
    private Long senderBankId;
    private Long receiverBankId;
    private Long categoryId;
    private String channel;
    private String email;

    public Transaction() {
    }

    public Transaction(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
    }

    public Transaction(String name, BigDecimal amount, String currency, String routingNumber, String beneficiaryName, Long senderId, Long receiverId, LocalDate date, LocalDateTime dateTime, LocalDate authorizedDate, LocalDateTime authorizedDateTime, String status, Long senderBankId, Long receiverBankId, Long categoryId, String channel, String email) {
        this.name = name;
        this.amount = amount;
        this.currency = currency;
        this.routingNumber = routingNumber;
        this.beneficiaryName = beneficiaryName;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.date = date;
        this.dateTime = dateTime;
        this.authorizedDate = authorizedDate;
        this.authorizedDateTime = authorizedDateTime;
        this.status = status;
        this.senderBankId = senderBankId;
        this.receiverBankId = receiverBankId;
        this.categoryId = categoryId;
        this.channel = channel;
        this.email = email;
    }

    public Transaction(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy, String name, BigDecimal amount, String currency, String routingNumber, String beneficiaryName, Long senderId, Long receiverId, LocalDate date, LocalDateTime dateTime, LocalDate authorizedDate, LocalDateTime authorizedDateTime, String status, Long senderBankId, Long receiverBankId, Long categoryId, String channel, String email) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
        this.name = name;
        this.amount = amount;
        this.currency = currency;
        this.routingNumber = routingNumber;
        this.beneficiaryName = beneficiaryName;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.date = date;
        this.dateTime = dateTime;
        this.authorizedDate = authorizedDate;
        this.authorizedDateTime = authorizedDateTime;
        this.status = status;
        this.senderBankId = senderBankId;
        this.receiverBankId = receiverBankId;
        this.categoryId = categoryId;
        this.channel = channel;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", routingNumber='" + routingNumber + '\'' +
                ", beneficiaryName='" + beneficiaryName + '\'' +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", date=" + date +
                ", dateTime=" + dateTime +
                ", authorizedDate=" + authorizedDate +
                ", authorizedDateTime=" + authorizedDateTime +
                ", status='" + status + '\'' +
                ", senderBankId=" + senderBankId +
                ", receiverBankId=" + receiverBankId +
                ", categoryId=" + categoryId +
                ", channel='" + channel + '\'' +
                ", email='" + email + '\'' +
                '}';
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

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getSenderBankId() {
        return senderBankId;
    }

    public void setSenderBankId(Long senderBankId) {
        this.senderBankId = senderBankId;
    }

    public Long getReceiverBankId() {
        return receiverBankId;
    }

    public void setReceiverBankId(Long receiverBankId) {
        this.receiverBankId = receiverBankId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
        if (!super.equals(o)) return false;

        Transaction that = (Transaction) o;
        return Objects.equals(name, that.name) && Objects.equals(amount, that.amount) && Objects.equals(currency, that.currency) && Objects.equals(routingNumber, that.routingNumber) && Objects.equals(beneficiaryName, that.beneficiaryName) && Objects.equals(senderId, that.senderId) && Objects.equals(receiverId, that.receiverId) && Objects.equals(date, that.date) && Objects.equals(dateTime, that.dateTime) && Objects.equals(authorizedDate, that.authorizedDate) && Objects.equals(authorizedDateTime, that.authorizedDateTime) && Objects.equals(status, that.status) && Objects.equals(senderBankId, that.senderBankId) && Objects.equals(receiverBankId, that.receiverBankId) && Objects.equals(categoryId, that.categoryId) && Objects.equals(channel, that.channel) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(amount);
        result = 31 * result + Objects.hashCode(currency);
        result = 31 * result + Objects.hashCode(routingNumber);
        result = 31 * result + Objects.hashCode(beneficiaryName);
        result = 31 * result + Objects.hashCode(senderId);
        result = 31 * result + Objects.hashCode(receiverId);
        result = 31 * result + Objects.hashCode(date);
        result = 31 * result + Objects.hashCode(dateTime);
        result = 31 * result + Objects.hashCode(authorizedDate);
        result = 31 * result + Objects.hashCode(authorizedDateTime);
        result = 31 * result + Objects.hashCode(status);
        result = 31 * result + Objects.hashCode(senderBankId);
        result = 31 * result + Objects.hashCode(receiverBankId);
        result = 31 * result + Objects.hashCode(categoryId);
        result = 31 * result + Objects.hashCode(channel);
        result = 31 * result + Objects.hashCode(email);
        return result;
    }
}
