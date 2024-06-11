package com.leopoldhsing.horizon.model.enumeration;

public enum DwollaCustomerStatus {
    /**
     * Customers of type unverified or receive-only always have this status.
     */
    UNVERIFIED("UNVERIFIED"),

    /**
     * Verified Customers of type personal or business can have this status. The initial verification attempt failed
     * because the information provided did not satisfy our verification check.
     * You can make one additional attempt by changing some or all the attributes of the existing Customer with a POST request.
     * If the additional attempt fails, the resulting status will be either document or suspended.
     */
    RETRY("RETRY"),

    /**
     * Verified Customers of type personal or business can have this status.
     * Dwolla requires additional documentation to identify the Customer in the document status. Read about Documents.
     */
    DOCUMENT("DOCUMENT"),

    /**
     * Verified Customers of type personal or business can have this status. The Customer is currently verified.
     */
    VERIFIED("VERIFIED"),

    /**
     * All Customer types can have a status of suspended. The Customer is suspended and may neither send nor receive funds.
     * Contact Dwolla support for more information.
     */
    SUSPENDED("SUSPENDED"),

    /**
     * All Customer types can have a status of deactivated. A deactivated Customer may neither send nor receive funds.
     * A deactivated Customer can be reactivated which moves the Customer to the status they were in prior to being deactivated.
     */
    DEACTIVATE("DEACTIVATE");

    private final String value;

    DwollaCustomerStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
