package com.rider.folly.json.types;

/**
 * Instruction to replace a LIMIT or LIMIT_ON_CLOSE order at a new price.
 * Original order will be cancelled and a new order placed at the new price for
 * the remaining stake.
 *
 * @author Ciaron Rider
 */
public class ReplaceInstruction {
    /**
     * Unique identifier for the bet
     */
    private String betId;

    /**
     * The price to replace the bet at
     */
    private double newPrice;

    public String getBetId() {
        return betId;
    }

    public double getNewPrice() {
        return newPrice;
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

        builder.append(indentString).append("Bet Id    : ").append(getBetId()).append('\n');
        builder.append(indentString).append("New Price : ").append(getNewPrice()).append('\n');

        return builder.toString();
    }
}
