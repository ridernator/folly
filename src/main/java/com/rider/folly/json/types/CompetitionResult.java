package com.rider.folly.json.types;

/**
 * Competition Result
 *
 * @author Ciaron Rider
 */
public class CompetitionResult {
    /**
     * Competition
     */
    private Competition competition;

    /**
     * Count of markets associated with this competition
     */
    private int marketCount;

    /**
     * Region in which this competition is happening
     */
    private String competitionRegion;

    public Competition getCompetition() {
        return competition;
    }

    public String getCompetitionRegion() {
        return competitionRegion;
    }

    public int getMarketCount() {
        return marketCount;
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

        if (getCompetition() == null) {
            builder.append(indentString).append("Competition        : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Competition        : ").append('\n').append(getCompetition().toString(indent + Indent.INDENT_SIZE));
        }

        builder.append(indentString).append("Competition Region : ").append(getCompetitionRegion()).append('\n');
        builder.append(indentString).append("Market Count       : ").append(getMarketCount()).append('\n');

        return builder.toString();
    }
}
