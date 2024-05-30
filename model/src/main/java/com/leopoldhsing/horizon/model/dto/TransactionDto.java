package com.leopoldhsing.horizon.model.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class TransactionDto {

    private String name;
    private BigDecimal amount;
    private String email;
    private String channel;
    private CategoryDto category;
    private UserDto sender;
    private UserDto receiver;
    private BankDto senderBank;
    private BankDto receiverBank;

    public TransactionDto() {
    }

    public TransactionDto(String name, BigDecimal amount, String email, String channel, CategoryDto category, UserDto sender, UserDto receiver, BankDto senderBank, BankDto receiverBank) {
        this.name = name;
        this.amount = amount;
        this.email = email;
        this.channel = channel;
        this.category = category;
        this.sender = sender;
        this.receiver = receiver;
        this.senderBank = senderBank;
        this.receiverBank = receiverBank;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", email='" + email + '\'' +
                ", channel='" + channel + '\'' +
                ", category=" + category +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", senderBank=" + senderBank +
                ", receiverBank=" + receiverBank +
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

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
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

    public BankDto getSenderBank() {
        return senderBank;
    }

    public void setSenderBank(BankDto senderBank) {
        this.senderBank = senderBank;
    }

    public BankDto getReceiverBank() {
        return receiverBank;
    }

    public void setReceiverBank(BankDto receiverBank) {
        this.receiverBank = receiverBank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionDto that = (TransactionDto) o;
        return Objects.equals(name, that.name) && Objects.equals(amount, that.amount) && Objects.equals(email, that.email) && Objects.equals(channel, that.channel) && Objects.equals(category, that.category) && Objects.equals(sender, that.sender) && Objects.equals(receiver, that.receiver) && Objects.equals(senderBank, that.senderBank) && Objects.equals(receiverBank, that.receiverBank);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(amount);
        result = 31 * result + Objects.hashCode(email);
        result = 31 * result + Objects.hashCode(channel);
        result = 31 * result + Objects.hashCode(category);
        result = 31 * result + Objects.hashCode(sender);
        result = 31 * result + Objects.hashCode(receiver);
        result = 31 * result + Objects.hashCode(senderBank);
        result = 31 * result + Objects.hashCode(receiverBank);
        return result;
    }
}
