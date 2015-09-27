package com.rider.folly.json.enums;

/**
 *
 * @author Ciaron Rider
 */
public enum SubscriptionStatus {
    /**
     * Any subscription status
     */
    ALL,
    /**
     * Only activated subscriptions
     */
    ACTIVATED,
    /**
     * Only unactivated subscriptions
     */
    UNACTIVATED,
    /**
     * Only cancelled subscriptions
     */
    CANCELLED,
    /**
     * Only expired subscriptions
     */
    EXPIRED

}
