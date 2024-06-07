package com.leopoldhsing.horizon.model.vo;

import java.util.Objects;

public class TransactionResponseVo {

    private String id;
    private String $id;
    private String name;
    private String paymentChannel;
    private String type;
    private String accountId;
    private Double amount;
    private Boolean pending;
    private String category;
    private String date;
    private String image;
    private String $createdAt;
    private String channel;
    private String senderBankId;
    private String receiverBankId;

    public TransactionResponseVo() {
    }

    public TransactionResponseVo(String id, String $id, String name, String paymentChannel, String type, String accountId, Double amount, Boolean pending, String category, String date, String image, String $createdAt, String channel, String senderBankId, String receiverBankId) {
        this.id = id;
        this.$id = $id;
        this.name = name;
        this.paymentChannel = paymentChannel;
        this.type = type;
        this.accountId = accountId;
        this.amount = amount;
        this.pending = pending;
        this.category = category;
        this.date = date;
        this.image = image;
        this.$createdAt = $createdAt;
        this.channel = channel;
        this.senderBankId = senderBankId;
        this.receiverBankId = receiverBankId;
    }

    @Override
    public String toString() {
        return "TransactionResponseVo{" +
                "id='" + id + '\'' +
                ", $id='" + $id + '\'' +
                ", name='" + name + '\'' +
                ", paymentChannel='" + paymentChannel + '\'' +
                ", type='" + type + '\'' +
                ", accountId='" + accountId + '\'' +
                ", amount=" + amount +
                ", pending=" + pending +
                ", category='" + category + '\'' +
                ", date='" + date + '\'' +
                ", image='" + image + '\'' +
                ", $createdAt='" + $createdAt + '\'' +
                ", channel='" + channel + '\'' +
                ", senderBankId='" + senderBankId + '\'' +
                ", receiverBankId='" + receiverBankId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String get$createdAt() {
        return $createdAt;
    }

    public void set$createdAt(String $createdAt) {
        this.$createdAt = $createdAt;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
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

        TransactionResponseVo that = (TransactionResponseVo) o;
        return Objects.equals(id, that.id) && Objects.equals($id, that.$id) && Objects.equals(name, that.name) && Objects.equals(paymentChannel, that.paymentChannel) && Objects.equals(type, that.type) && Objects.equals(accountId, that.accountId) && Objects.equals(amount, that.amount) && Objects.equals(pending, that.pending) && Objects.equals(category, that.category) && Objects.equals(date, that.date) && Objects.equals(image, that.image) && Objects.equals($createdAt, that.$createdAt) && Objects.equals(channel, that.channel) && Objects.equals(senderBankId, that.senderBankId) && Objects.equals(receiverBankId, that.receiverBankId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode($id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(paymentChannel);
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(accountId);
        result = 31 * result + Objects.hashCode(amount);
        result = 31 * result + Objects.hashCode(pending);
        result = 31 * result + Objects.hashCode(category);
        result = 31 * result + Objects.hashCode(date);
        result = 31 * result + Objects.hashCode(image);
        result = 31 * result + Objects.hashCode($createdAt);
        result = 31 * result + Objects.hashCode(channel);
        result = 31 * result + Objects.hashCode(senderBankId);
        result = 31 * result + Objects.hashCode(receiverBankId);
        return result;
    }
}
