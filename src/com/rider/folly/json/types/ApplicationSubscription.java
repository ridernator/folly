package com.rider.folly.json.types;

import com.rider.folly.json.enums.SubscriptionStatus;
import java.util.Date;

/**
 * Application subscription details
 *
 * @author Ciaron Rider
 */
public class ApplicationSubscription {
    /**
     * Application key identifier
     */
    private String subscriptionToken;

    /**
     * Subscription Expiry date
     */
    private Date expiryDateTime;

    /**
     * Subscription Expired date
     */
    private Date expiredDateTime;

    /**
     * Subscription Create date
     */
    private Date createdDateTime;

    /**
     * Subscription Activation date
     */
    private Date activationDateTime;

    /**
     * Subscription Cancelled date
     */
    private Date cancellationDateTime;

    /**
     * Subscription status
     */
    private SubscriptionStatus subscriptionStatus;

    /**
     * Client reference
     */
    private String clientReference;

    /**
     * Vendor client Id
     */
    private String vendorClientId;

    public Date getActivationDateTime() {
        return activationDateTime;
    }

    public Date getCancellationDateTime() {
        return cancellationDateTime;
    }

    public String getClientReference() {
        return clientReference;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public Date getExpiredDateTime() {
        return expiredDateTime;
    }

    public Date getExpiryDateTime() {
        return expiryDateTime;
    }

    public SubscriptionStatus getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public String getSubscriptionToken() {
        return subscriptionToken;
    }

    public String getVendorClientId() {
        return vendorClientId;
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString(final int indent) {
        final StringBuilder builder = new StringBuilder();
        String indentString = "";

        for (int indentIndex = 0; indentIndex < indent; indentIndex++) {
            indentString += ' ';
        }

        builder.append(indentString).append("Subscription Token    : ").append(getSubscriptionToken()).append('\n');
        builder.append(indentString).append("Expiry DateTime       : ").append(getExpiryDateTime()).append('\n');
        builder.append(indentString).append("Expired DateTime      : ").append(getExpiredDateTime()).append('\n');
        builder.append(indentString).append("Created DateTime      : ").append(getCreatedDateTime()).append('\n');
        builder.append(indentString).append("Activation DateTime   : ").append(getActivationDateTime()).append('\n');
        builder.append(indentString).append("Cancellation DateTime : ").append(getCancellationDateTime()).append('\n');
        builder.append(indentString).append("Subscription Status   : ").append(getSubscriptionStatus()).append('\n');
        builder.append(indentString).append("Client Reference      : ").append(getClientReference()).append('\n');
        builder.append(indentString).append("Vendor Client Id      : ").append(getVendorClientId()).append('\n');

        return builder.toString();
    }
}
