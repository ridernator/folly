package com.rider.folly.json.enums;

/**
 *
 * @author Ciaron Rider
 */
public enum MatchProjection {
    /**
     * No rollup, return raw fragments
     */
    NO_ROLLUP,
    /**
     * Rollup matched amounts by distinct matched prices per side.
     */
    ROLLED_UP_BY_PRICE,
    /**
     * Rollup matched amounts by average matched price per side
     */
    ROLLED_UP_BY_AVG_PRICE

}
