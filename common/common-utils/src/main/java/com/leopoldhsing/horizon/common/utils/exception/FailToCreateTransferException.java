package com.leopoldhsing.horizon.common.utils.exception;

import java.math.BigDecimal;

public class FailToCreateTransferException extends RuntimeException {
    public FailToCreateTransferException(String sourceFundingSourceUrl, String targetFundingTargetUrl, BigDecimal amount) {
        super("Error creating dwolla transfer, from " + sourceFundingSourceUrl + ", to " + targetFundingTargetUrl + ", amount " + amount);
    }
}
