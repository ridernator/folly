package com.rider.folly.json.types;

import com.rider.folly.json.enums.SubscriptionStatus;
import java.util.Date;

/**
 * Subscription token information
 *
 * @author Ciaron Rider
 */
public class SubscriptionTokenInfo {
    /**
     * Subscription token
     */
    private String subscriptionToken;

    /**
     * Subscription Activated date
     */
    private Date activatedDateTime;

    /**
     * Subscription Expiry date
     */
    private Date expiryDateTime;

    /**
     * Subscription Expired date
     */
    private Date expiredDateTime;

    /**
     * Subscription Cancelled date
     */
    private Date cancellationDateTime;

    /**
     * Subscription status
     */
    private SubscriptionStatus subscriptionStatus;

    public Date getCancellationDateTime() {
        return cancellationDateTime;
    }

    public Date getActivatedDateTime() {
        return activatedDateTime;
    }

    public String getSubscriptionToken() {
        return subscriptionToken;
    }

    public SubscriptionStatus getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public Date getExpiryDateTime() {
        return expiryDateTime;
    }

    public Date getExpiredDateTime() {
        return expiredDateTime;
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
        builder.append(indentString).append("Activated DateTime    : ").append(getActivatedDateTime()).append('\n');
        builder.append(indentString).append("Expiry DateTime       : ").append(getExpiryDateTime()).append('\n');
        builder.append(indentString).append("Expired DateTime      : ").append(getExpiredDateTime()).append('\n');
        builder.append(indentString).append("Cancellation DateTime : ").append(getCancellationDateTime()).append('\n');
        builder.append(indentString).append("Subscription Status   : ").append(getSubscriptionStatus()).append('\n');

        return builder.toString();
    }
}
