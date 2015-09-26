package com.rider.folly.json.enums;

/**
 *
 * @author Ciaron Rider
 */
public enum MarketBettingType {
    /**
     * Odds Market
     */
    ODDS,
    /**
     * Line Market
     */
    LINE,
    /**
     * Range Market
     */
    RANGE,
    /**
     * Asian Handicap Market
     */
    ASIAN_HANDICAP_DOUBLE_LINE,
    /**
     * Asian Single Line Market
     */
    ASIAN_HANDICAP_SINGLE_LINE,
    /**
     * Sportsbook Odds Market. This type is deprecated and will be removed in
     * future releases, when Sportsbook markets will be represented as ODDS
     * market but with a different product type.
     */
    FIXED_ODDS

}
