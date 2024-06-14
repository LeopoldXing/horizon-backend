package com.leopoldhsing.horizon.model.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class TransferCreationDto {
    private String sourceFundingSourceUrl;
    private String destinationFundingSourceUrl;
    private BigDecimal amount;

    public TransferCreationDto() {
    }

    public TransferCreationDto(String sourceFundingSourceUrl, String destinationFundingSourceUrl, BigDecimal amount) {
        this.sourceFundingSourceUrl = sourceFundingSourceUrl;
        this.destinationFundingSourceUrl = destinationFundingSourceUrl;
        this.amount = amount;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransferCreationDto that = (TransferCreationDto) o;
        return Objects.equals(sourceFundingSourceUrl, that.sourceFundingSourceUrl) && Objects.equals(destinationFundingSourceUrl, that.destinationFundingSourceUrl) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(sourceFundingSourceUrl);
        result = 31 * result + Objects.hashCode(destinationFundingSourceUrl);
        result = 31 * result + Objects.hashCode(amount);
        return result;
    }
}
