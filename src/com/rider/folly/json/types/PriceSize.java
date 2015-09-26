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

    public double getPrice() {
        return price;
    }

    public double getSize() {
        return size;
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

        builder.append(indentString).append("Price : ").append(getPrice()).append('\n');
        builder.append(indentString).append("Size  : ").append(getSize()).append('\n');

        return builder.toString();
    }

}
