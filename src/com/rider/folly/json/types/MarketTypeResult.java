package com.rider.folly.json.types;

/**
 * MarketType Result
 *
 * @author Ciaron Rider
 */
public class MarketTypeResult {
    /**
     * Market Type
     */
    private String marketType;

    /**
     * Count of markets associated with this marketType
     */
    private int marketCount;

    public int getMarketCount() {
        return marketCount;
    }

    public String getMarketType() {
        return marketType;
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

        builder.append(indentString).append("Market Type  : ").append(getMarketType()).append('\n');
        builder.append(indentString).append("Market Count : ").append(getMarketCount()).append('\n');

        return builder.toString();
    }
}
