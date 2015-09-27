package com.rider.folly.json.types;

/**
 *
 * @author Ciaron Rider
 */
public class RunnerId {
    /**
     * The id of the market bet on
     */
    private String marketId;

    /**
     * The id of the selection bet on
     */
    private long selectionId;

    /**
     * The handicap associated with the runner in case of asian handicap
     * markets, otherwise returns '0.0'.
     */
    private double handicap;

    public double getHandicap() {
        return handicap;
    }

    public String getMarketId() {
        return marketId;
    }

    public long getSelectionId() {
        return selectionId;
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

        builder.append(indentString).append("Market Id    : ").append(getMarketId()).append('\n');
        builder.append(indentString).append("Selection Id : ").append(getSelectionId()).append('\n');
        builder.append(indentString).append("Handicap     : ").append(getHandicap()).append('\n');

        return builder.toString();
    }
}
