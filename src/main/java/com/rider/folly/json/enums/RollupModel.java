package com.rider.folly.json.enums;

/**
 *
 * @author Ciaron Rider
 */
public enum RollupModel {
    /**
     * The volumes will be rolled up to the minimum value which is >=
     * rollupLimit.
     */
    STAKE,
    /**
     * The volumes will be rolled up to the minimum value where the payout(
     * price * volume ) is >= rollupLimit.
     */
    PAYOUT,
    /**
     * The volumes will be rolled up to the minimum value which is >=
     * rollupLimit, until a lay price threshold. There after, the volumes will
     * be rolled up to the minimum value such that the liability >= a minimum
     * liability. Not supported as yet.
     */
    MANAGED_LIABILITY,
    /**
     * No rollup will be applied. However the volumes will be filtered by
     * currency specific minimum stake unless overridden specifically for the
     * channel.
     */
    NONE

}
