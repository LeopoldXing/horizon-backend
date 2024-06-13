package com.leopoldhsing.horizon.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "transactions")
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
    private LocalDateTime datetime;
    private LocalDate authorizedDate;
    private LocalDateTime authorizedDatetime;
    private String status;
    private Long senderAccountId;
    private Long receiverAccountId;
    private Long categoryId;
    private String channel;
    private String email;

    public Transaction() {
    }

    public Transaction(Long id, LocalDateTime createdAt, LocalDateTime lastModifiedAt, String createdBy, String lastModifiedBy) {
        super(id, createdAt, lastModifiedAt, createdBy, lastModifiedBy);
    }

    public Transaction(String name, BigDecimal amount, String currency, String routingNumber, String beneficiaryName, Long senderId, Long receiverId, LocalDate date, LocalDateTime datetime, LocalDate authorizedDate, LocalDateTime authorizedDatetime, String status, Long senderAccountId, Long receiverAccountId, Long categoryId, String channel, String email) {
        this.name = name;
        this.amount = amount;
        this.currency = currency;
        this.routingNumber = routingNumber;
        this.beneficiaryName = beneficiaryName;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.date = date;
        this.datetime = datetime;
        this.authorizedDate = authorizedDate;
        this.authorizedDatetime = authorizedDatetime;
        this.status = status;
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
        this.categoryId = categoryId;
        this.channel = channel;
        this.email = email;
    }

    public Transaction(Long id, LocalDateTime createdAt, LocalDateTime lastModifiedAt, String createdBy, String lastModifiedBy, String name, BigDecimal amount, String currency, String routingNumber, String beneficiaryName, Long senderId, Long receiverId, LocalDate date, LocalDateTime datetime, LocalDate authorizedDate, LocalDateTime authorizedDatetime, String status, Long senderAccountId, Long receiverAccountId, Long categoryId, String channel, String email) {
        super(id, createdAt, lastModifiedAt, createdBy, lastModifiedBy);
        this.name = name;
        this.amount = amount;
        this.currency = currency;
        this.routingNumber = routingNumber;
        this.beneficiaryName = beneficiaryName;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.date = date;
        this.datetime = datetime;
        this.authorizedDate = authorizedDate;
        this.authorizedDatetime = authorizedDatetime;
        this.status = status;
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
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
                ", datetime=" + datetime +
                ", authorizedDate=" + authorizedDate +
                ", authorizedDatetime=" + authorizedDatetime +
                ", status='" + status + '\'' +
                ", senderAccountId=" + senderAccountId +
                ", receiverAccountId=" + receiverAccountId +
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(Long senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public Long getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(Long receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
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
        return Objects.equals(name, that.name) && Objects.equals(amount, that.amount) && Objects.equals(currency, that.currency) && Objects.equals(routingNumber, that.routingNumber) && Objects.equals(beneficiaryName, that.beneficiaryName) && Objects.equals(senderId, that.senderId) && Objects.equals(receiverId, that.receiverId) && Objects.equals(date, that.date) && Objects.equals(datetime, that.datetime) && Objects.equals(authorizedDate, that.authorizedDate) && Objects.equals(authorizedDatetime, that.authorizedDatetime) && Objects.equals(status, that.status) && Objects.equals(senderAccountId, that.senderAccountId) && Objects.equals(receiverAccountId, that.receiverAccountId) && Objects.equals(categoryId, that.categoryId) && Objects.equals(channel, that.channel) && Objects.equals(email, that.email);
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
        result = 31 * result + Objects.hashCode(datetime);
        result = 31 * result + Objects.hashCode(authorizedDate);
        result = 31 * result + Objects.hashCode(authorizedDatetime);
        result = 31 * result + Objects.hashCode(status);
        result = 31 * result + Objects.hashCode(senderAccountId);
        result = 31 * result + Objects.hashCode(receiverAccountId);
        result = 31 * result + Objects.hashCode(categoryId);
        result = 31 * result + Objects.hashCode(channel);
        result = 31 * result + Objects.hashCode(email);
        return result;
    }
}
