package com.rider.folly.json.types;

import com.rider.folly.json.enums.PersistenceType;

/**
 * Place a new LIMIT order (simple exchange bet for immediate execution)
 *
 * @author Ciaron Rider
 */
public class LimitOrder {
    /**
     * The size of the bet. Please note: For market type EACH_WAY. The total
     * stake = size x 2
     */
    private double size;

    /**
     * The limit price
     */
    private double price;

    /**
     * What to do with the order at turn-in-play
     */
    private PersistenceType persistenceType;

    public PersistenceType getPersistenceType() {
        return persistenceType;
    }

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

        builder.append(indentString).append("Size             : ").append(getSize()).append('\n');
        builder.append(indentString).append("Prixe            : ").append(getPrice()).append('\n');
        builder.append(indentString).append("Persistence Type : ").append(getPersistenceType()).append('\n');

        return builder.toString();
    }
}
