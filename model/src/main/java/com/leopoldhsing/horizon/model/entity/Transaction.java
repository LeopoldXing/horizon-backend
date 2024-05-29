package com.leopoldhsing.horizon.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
public class Transaction extends BaseEntity {

    @Column(name = "name")
    private String transactionName;

    private BigDecimal amount;

    private String email;

    private String channel;

    private String category;

    private String senderId;

    private String receiverId;

    private String senderBankId;

    private String receiverBankId;

    public Transaction() {
    }

    public Transaction(String id, Date createdAt, Date updatedAt, String createdBy, String updatedBy) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
    }

    public Transaction(String transactionName, BigDecimal amount, String email, String channel, String category, String senderId, String receiverId, String senderBankId, String receiverBankId) {
        this.transactionName = transactionName;
        this.amount = amount;
        this.email = email;
        this.channel = channel;
        this.category = category;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.senderBankId = senderBankId;
        this.receiverBankId = receiverBankId;
    }

    public Transaction(String id, Date createdAt, Date updatedAt, String createdBy, String updatedBy, String transactionName, BigDecimal amount, String email, String channel, String category, String senderId, String receiverId, String senderBankId, String receiverBankId) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
        this.transactionName = transactionName;
        this.amount = amount;
        this.email = email;
        this.channel = channel;
        this.category = category;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.senderBankId = senderBankId;
        this.receiverBankId = receiverBankId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionName='" + transactionName + '\'' +
                ", amount=" + amount +
                ", email='" + email + '\'' +
                ", channel='" + channel + '\'' +
                ", category='" + category + '\'' +
                ", senderId='" + senderId + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", senderBankId='" + senderBankId + '\'' +
                ", receiverBankId='" + receiverBankId + '\'' +
                '}';
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getSenderBankId() {
        return senderBankId;
    }

    public void setSenderBankId(String senderBankId) {
        this.senderBankId = senderBankId;
    }

    public String getReceiverBankId() {
        return receiverBankId;
    }

    public void setReceiverBankId(String receiverBankId) {
        this.receiverBankId = receiverBankId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Transaction that = (Transaction) o;
        return Objects.equals(transactionName, that.transactionName) && Objects.equals(amount, that.amount) && Objects.equals(email, that.email) && Objects.equals(channel, that.channel) && Objects.equals(category, that.category) && Objects.equals(senderId, that.senderId) && Objects.equals(receiverId, that.receiverId) && Objects.equals(senderBankId, that.senderBankId) && Objects.equals(receiverBankId, that.receiverBankId);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(transactionName);
        result = 31 * result + Objects.hashCode(amount);
        result = 31 * result + Objects.hashCode(email);
        result = 31 * result + Objects.hashCode(channel);
        result = 31 * result + Objects.hashCode(category);
        result = 31 * result + Objects.hashCode(senderId);
        result = 31 * result + Objects.hashCode(receiverId);
        result = 31 * result + Objects.hashCode(senderBankId);
        result = 31 * result + Objects.hashCode(receiverBankId);
        return result;
    }
}
