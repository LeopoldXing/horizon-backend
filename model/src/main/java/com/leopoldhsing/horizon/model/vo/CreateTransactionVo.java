package com.leopoldhsing.horizon.model.vo;

import java.util.Objects;

public class CreateTransactionVo {
    private String name;
    private String amount;
    private String senderId;
    private String senderBankId;
    private String receiverId;
    private String receiverBankId;
    private String email;
    private String sourceFundingSourceUrl;
    private String destinationFundingSourceUrl;

    public CreateTransactionVo() {
    }

    public CreateTransactionVo(String name, String amount, String senderId, String senderBankId, String receiverId, String receiverBankId, String email, String sourceFundingSourceUrl, String destinationFundingSourceUrl) {
        this.name = name;
        this.amount = amount;
        this.senderId = senderId;
        this.senderBankId = senderBankId;
        this.receiverId = receiverId;
        this.receiverBankId = receiverBankId;
        this.email = email;
        this.sourceFundingSourceUrl = sourceFundingSourceUrl;
        this.destinationFundingSourceUrl = destinationFundingSourceUrl;
    }

    @Override
    public String toString() {
        return "CreateTransactionVo{" +
                "name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                ", senderId='" + senderId + '\'' +
                ", senderBankId='" + senderBankId + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", receiverBankId='" + receiverBankId + '\'' +
                ", email='" + email + '\'' +
                ", sourceFundingSourceUrl='" + sourceFundingSourceUrl + '\'' +
                ", destinationFundingSourceUrl='" + destinationFundingSourceUrl + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderBankId() {
        return senderBankId;
    }

    public void setSenderBankId(String senderBankId) {
        this.senderBankId = senderBankId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverBankId() {
        return receiverBankId;
    }

    public void setReceiverBankId(String receiverBankId) {
        this.receiverBankId = receiverBankId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSourceFundingSourceUrl() {
        return sourceFundingSourceUrl;
    }

    public void setSourceFundingSourceUrl(String sourceFundingSourceUrl) {
        this.sourceFundingSourceUrl = sourceFundingSourceUrl;
    }

    public String getDestinationFundingSourceUrl() {
        return destinationFundingSourceUrl;
    }

    public void setDestinationFundingSourceUrl(String destinationFundingSourceUrl) {
        this.destinationFundingSourceUrl = destinationFundingSourceUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreateTransactionVo that = (CreateTransactionVo) o;
        return Objects.equals(name, that.name) && Objects.equals(amount, that.amount) && Objects.equals(senderId, that.senderId) && Objects.equals(senderBankId, that.senderBankId) && Objects.equals(receiverId, that.receiverId) && Objects.equals(receiverBankId, that.receiverBankId) && Objects.equals(email, that.email) && Objects.equals(sourceFundingSourceUrl, that.sourceFundingSourceUrl) && Objects.equals(destinationFundingSourceUrl, that.destinationFundingSourceUrl);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(amount);
        result = 31 * result + Objects.hashCode(senderId);
        result = 31 * result + Objects.hashCode(senderBankId);
        result = 31 * result + Objects.hashCode(receiverId);
        result = 31 * result + Objects.hashCode(receiverBankId);
        result = 31 * result + Objects.hashCode(email);
        result = 31 * result + Objects.hashCode(sourceFundingSourceUrl);
        result = 31 * result + Objects.hashCode(destinationFundingSourceUrl);
        return result;
    }
}
