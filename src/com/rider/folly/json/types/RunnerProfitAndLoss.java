package com.rider.folly.json.types;

/**
 *
 * @author Ciaron Rider
 */
public class RunnerProfitAndLoss {
    /**
     * The unique identifier for the selection
     */
    private long selectionId;

    /**
     * Profit or loss for the market if this selection is the winner.
     */
    private double ifWin;

    /**
     * Profit or loss for the market if this selection is the loser. Only
     * returned for multi-winner odds markets.
     */
    private double ifLose;

    /**
     * Profit or loss for the market if this selection is placed. Applies to
     * marketType EACH_WAY only.
     */
    private double ifPlace;

    public double getIfLose() {
        return ifLose;
    }

    public double getIfPlace() {
        return ifPlace;
    }

    public double getIfWin() {
        return ifWin;
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

        for (int indentIndex = 0; indentIndex < indent; indentIndex++) {
            indentString += ' ';
        }

        builder.append(indentString).append("Selection Id : ").append(getSelectionId()).append('\n');
        builder.append(indentString).append("If Win       : ").append(getIfWin()).append('\n');
        builder.append(indentString).append("If Lose      : ").append(getIfLose()).append('\n');
        builder.append(indentString).append("If Place     : ").append(getIfPlace()).append('\n');

        return builder.toString();
    }
}
