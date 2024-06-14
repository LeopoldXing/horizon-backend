package com.leopoldhsing.horizon.model.vo;

import java.util.Objects;

public class TransactionCreationVo {
    private String name;
    private String amount;
    private String senderAccountId;
    private String receiverAccountShareableId;
    private String receiverEmail;
    private String sourceFundingSourceUrl;

    public TransactionCreationVo() {
    }

    public TransactionCreationVo(String name, String amount, String senderAccountId, String receiverAccountShareableId, String receiverEmail, String sourceFundingSourceUrl) {
        this.name = name;
        this.amount = amount;
        this.senderAccountId = senderAccountId;
        this.receiverAccountShareableId = receiverAccountShareableId;
        this.receiverEmail = receiverEmail;
        this.sourceFundingSourceUrl = sourceFundingSourceUrl;
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

    public String getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(String senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public String getReceiverAccountShareableId() {
        return receiverAccountShareableId;
    }

    public void setReceiverAccountShareableId(String receiverAccountShareableId) {
        this.receiverAccountShareableId = receiverAccountShareableId;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getSourceFundingSourceUrl() {
        return sourceFundingSourceUrl;
    }

    public void setSourceFundingSourceUrl(String sourceFundingSourceUrl) {
        this.sourceFundingSourceUrl = sourceFundingSourceUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionCreationVo that = (TransactionCreationVo) o;
        return Objects.equals(name, that.name) && Objects.equals(amount, that.amount) && Objects.equals(senderAccountId, that.senderAccountId) && Objects.equals(receiverAccountShareableId, that.receiverAccountShareableId) && Objects.equals(receiverEmail, that.receiverEmail) && Objects.equals(sourceFundingSourceUrl, that.sourceFundingSourceUrl);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(amount);
        result = 31 * result + Objects.hashCode(senderAccountId);
        result = 31 * result + Objects.hashCode(receiverAccountShareableId);
        result = 31 * result + Objects.hashCode(receiverEmail);
        result = 31 * result + Objects.hashCode(sourceFundingSourceUrl);
        return result;
    }
}
