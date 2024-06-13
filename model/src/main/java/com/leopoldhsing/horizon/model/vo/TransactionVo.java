package com.leopoldhsing.horizon.model.vo;

import java.util.Objects;

public class TransactionVo {

    private String name;
    private String amount;
    private String senderId;
    private String receiverId;
    private String senderBankId;
    private String receiverBankId;
    private String email;
    private String sourceFundingSourceUrl;
    private String destinationFundingSourceUrl;
    private String shareableId;

    public TransactionVo() {
    }

    public TransactionVo(String name, String amount, String senderId, String receiverId, String senderBankId, String receiverBankId, String email, String sourceFundingSourceUrl, String destinationFundingSourceUrl, String shareableId) {
        this.name = name;
        this.amount = amount;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.senderBankId = senderBankId;
        this.receiverBankId = receiverBankId;
        this.email = email;
        this.sourceFundingSourceUrl = sourceFundingSourceUrl;
        this.destinationFundingSourceUrl = destinationFundingSourceUrl;
        this.shareableId = shareableId;
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

    public String getShareableId() {
        return shareableId;
    }

    public void setShareableId(String shareableId) {
        this.shareableId = shareableId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionVo that = (TransactionVo) o;
        return Objects.equals(name, that.name) && Objects.equals(amount, that.amount) && Objects.equals(senderId, that.senderId) && Objects.equals(receiverId, that.receiverId) && Objects.equals(senderBankId, that.senderBankId) && Objects.equals(receiverBankId, that.receiverBankId) && Objects.equals(email, that.email) && Objects.equals(sourceFundingSourceUrl, that.sourceFundingSourceUrl) && Objects.equals(destinationFundingSourceUrl, that.destinationFundingSourceUrl) && Objects.equals(shareableId, that.shareableId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(amount);
        result = 31 * result + Objects.hashCode(senderId);
        result = 31 * result + Objects.hashCode(receiverId);
        result = 31 * result + Objects.hashCode(senderBankId);
        result = 31 * result + Objects.hashCode(receiverBankId);
        result = 31 * result + Objects.hashCode(email);
        result = 31 * result + Objects.hashCode(sourceFundingSourceUrl);
        result = 31 * result + Objects.hashCode(destinationFundingSourceUrl);
        result = 31 * result + Objects.hashCode(shareableId);
        return result;
    }
}
