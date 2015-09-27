package com.rider.folly.json.types;

/**
 * Place a new MARKET_ON_CLOSE bet
 *
 * @author Ciaron Rider
 */
public class MarketOnCloseOrder {
    /**
     * The size of the bet.
     */
    private double liability;

    public double getLiability() {
        return liability;
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString(final int indent) {
        final StringBuilder builder = new StringBuilder();
        String indentString = "";

        for (int index = 0; index < indent; index++) {
            indentString += ' ';
        }

        builder.append(indentString).append("Liability : ").append(getLiability()).append('\n');

        return builder.toString();
    }
}
