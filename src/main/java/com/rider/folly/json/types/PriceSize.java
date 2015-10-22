package com.rider.folly.json.types;

/**
 *
 * @author Ciaron Rider
 */
public class PriceSize {
    /**
     * The price available
     */
    private double price;

    /**
     * The stake available
     */
    private double size;

    public double getOdds() {
        return price;
    }

    public double getAmount() {
        return size;
    }

    @Override
    public boolean equals(final Object otherObject) {
        boolean returnVal = false;

        if (otherObject != null) {
            if (otherObject instanceof PriceSize) {
                final PriceSize other = (PriceSize) otherObject;

                returnVal = true;

                returnVal &= (getAmount() == other.getAmount());
                returnVal &= (getOdds() == other.getOdds());
            }
        }

        return returnVal;
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

        builder.append(indentString).append("Odds   : ").append(getOdds()).append('\n');
        builder.append(indentString).append("Amount : ").append(getAmount()).append('\n');

        return builder.toString();
    }

}
