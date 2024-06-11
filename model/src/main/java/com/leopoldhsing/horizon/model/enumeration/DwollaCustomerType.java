package com.leopoldhsing.horizon.model.enumeration;

public enum DwollaCustomerType {

    /**
     * Personal Verified Customers can be used in any funds flows, as they can both send and receive funds.
     * This Customer type can also hold a balance. The individual being onboarded as a personal Verified Customer will need to
     * complete the identity verification process prior to being able to send or receive funds from/to their bank account.
     * CIP verification involves passing Customer data to verify them, including their name, date of birth,
     * and last four digits of their social security number. For more information about verifying this Customer type in our Customer verification guide.
     * With a per-transaction default send limit of $10,000, this Customer type is able to interact with Dwolla and your application seamlessly.
     */
    PERSONAL_VERIFIED_CUSTOMER("PERSONAL_VERIFIED_CUSTOMER"),

    /**
     * Business Verified Customers are unique in their sign-up flow, as they need multiple parties to be verified. These will include:
     * The Business (required)
     * The Controller (Conditionally Required)
     * The Beneficial Owner (Conditionally Required)
     * Business Verified Customers will need an Account Admin to sign up the company during the onboarding process.
     * This Account Admin is not identity verified. To become a fully verified Customer, a controller and/or a beneficial owner may need to be identity verified.
     * A controller is any natural individual who holds significant responsibilities to control, manage, or direct a company or other corporate entity (i.e. CEO, CFO, General Partner, President, etc).
     * A company may have more than one controller, but only one controller’s information must be collected.
     * A beneficial owner is any natural person who, directly or indirectly, owns 25% or more of the equity interests of the company.
     * The Controller will need to provide information to be fully identity verified.
     * This includes their last four SSN and date of birth for identity verification purposes.
     * For certain business types, a business’ EIN will also need to be provided as part of the CIP process.
     * For more information about adding a controller, check out our business verified Customer creation article.
     * Certain business types may also need to add and certify beneficial ownership.
     * You can find more information about adding beneficial owners in our developer resource article.
     * To learn more about certifying beneficial ownership, reference the certify beneficial ownership section in the business verified customer guide.
     * For a full series of steps that goes in depth on business verified Customers, take a look at our Customer verification guide.
     * This guide also goes into detail on the identity verification process for controllers and beneficial owners.
     */
    BUSINESS_VERIFIED_CUSTOMER("BUSINESS_VERIFIED_CUSTOMER"),

    /**
     * An unverified Customer type requires a minimal amount of information : firstName, lastName email, and optionally businessName for businesses.
     * While Customer creation and onboarding is light weight compared to a verified Customer, there are a few things to consider when choosing this customer type.
     * Unverified Customers have a default transaction send limit of $5,000 per week. A week is defined as Monday to Sunday UTC time.
     * If you have an unverified Customer looking to send more than $5,000 in a week,
     * you may want to explore upgrading them to a verified Customer type or contacting sales for more information about customizing the send limit.
     * As this Customer is not CIP verified, they will only be able to transact with verified Customers or your Dwolla Master Account.
     */
    UNVERIFIED_CUSTOMER("UNVERIFIED_CUSTOMER"),

    /**
     * Receive-only Users are restricted to payouts only funds flow.
     * This user type maintains limited functionality in the API and is only eligible to receive transfers to an attached bank account.
     * This user type can only interact with verified Customers and a Dwolla Master Account.
     */
    RECEIVE_ONLY_CUSTOMER("RECEIVE_ONLY_CUSTOMER");

    private final String value;

    DwollaCustomerType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
