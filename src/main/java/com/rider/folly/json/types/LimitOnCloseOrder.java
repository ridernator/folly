package com.rider.folly.json.types;

/**
 * Place a new LIMIT_ON_CLOSE bet
 *
 * @author Ciaron Rider
 */
public class LimitOnCloseOrder {
    /**
     * The size of the bet.
     */
    private double liability;

    /**
     * The limit price of the bet if LOC
     */
    private double price;

    public double getLiability() {
        return liability;
    }

    public double getPrice() {
        return price;
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

        builder.append(indentString).append("Price     : ").append(getPrice()).append('\n');
        builder.append(indentString).append("Liability : ").append(getLiability()).append('\n');

        return builder.toString();
    }
}
