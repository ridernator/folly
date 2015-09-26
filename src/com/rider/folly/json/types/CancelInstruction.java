package com.rider.folly.json.types;

/**
 * Instruction to fully or partially cancel an order (only applies to LIMIT
 * orders)
 *
 * @author Ciaron Rider
 */
public class CancelInstruction {
    /**
     * The betId
     */
    private String betId;

    /**
     * If supplied then this is a partial cancel. Should be set to 'null' if no
     * size reduction is required.
     */
    private double sizeReduction;

    public String getBetId() {
        return betId;
    }

    public double getSizeReduction() {
        return sizeReduction;
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

        builder.append(indentString).append("Bet Id         : ").append(getBetId()).append('\n');
        builder.append(indentString).append("Size Reduction : ").append(getSizeReduction()).append('\n');

        return builder.toString();
    }
}
