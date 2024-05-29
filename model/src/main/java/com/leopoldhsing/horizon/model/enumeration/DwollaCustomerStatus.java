package com.leopoldhsing.horizon.model.enumeration;

public enum DwollaCustomerStatus {
    /**
     * Customers of type unverified or receive-only always have this status.
     */
    UNVERIFIED(1),

    /**
     * Verified Customers of type personal or business can have this status. The initial verification attempt failed
     * because the information provided did not satisfy our verification check.
     * You can make one additional attempt by changing some or all the attributes of the existing Customer with a POST request.
     * If the additional attempt fails, the resulting status will be either document or suspended.
     */
    RETRY(2),

    /**
     * Verified Customers of type personal or business can have this status.
     * Dwolla requires additional documentation to identify the Customer in the document status. Read about Documents.
     */
    DOCUMENT(3),

    /**
     * Verified Customers of type personal or business can have this status. The Customer is currently verified.
     */
    VERIFIED(4),

    /**
     * All Customer types can have a status of suspended. The Customer is suspended and may neither send nor receive funds.
     * Contact Dwolla support for more information.
     */
    SUSPENDED(5),

    /**
     * All Customer types can have a status of deactivated. A deactivated Customer may neither send nor receive funds.
     * A deactivated Customer can be reactivated which moves the Customer to the status they were in prior to being deactivated.
     */
    DEACTIVATE(6);

    private final int statusCode;

    DwollaCustomerStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "DwollaCustomerStatus{" +
                "statusCode=" + statusCode +
                '}';
    }
}
