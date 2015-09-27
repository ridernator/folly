package com.rider.folly.json.types;

import com.rider.folly.json.enums.Side;
import java.util.Date;

/**
 * An individual bet Match, or rollup by price or avg price. Rollup depends on
 * the requested MatchProjection
 *
 * @author Ciaron Rider
 */
public class Match {
    /**
     * Only present if no rollup
     */
    private String betId;

    /**
     * Only present if no rollup
     */
    private String matchId;

    /**
     * Indicates if the bet is a Back or a LAY
     */
    private Side side;

    /**
     * Either actual match price or avg match price depending on rollup.
     */
    private double price;

    /**
     * Size matched at in this fragment, or at this price or avg price depending
     * on rollup
     */
    private double size;

    /**
     * Only present if no rollup
     */
    private Date matchDate;

    public String getBetId() {
        return betId;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public String getMatchId() {
        return matchId;
    }

    public double getPrice() {
        return price;
    }

    public Side getSide() {
        return side;
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

        builder.append(indentString).append("Bet Id     : ").append(getBetId()).append('\n');
        builder.append(indentString).append("Match Id   : ").append(getMatchId()).append('\n');
        builder.append(indentString).append("Side       : ").append(getSide()).append('\n');
        builder.append(indentString).append("Price      : ").append(getPrice()).append('\n');
        builder.append(indentString).append("Size       : ").append(getSize()).append('\n');
        builder.append(indentString).append("Match Date : ").append(getMatchDate()).append('\n');

        return builder.toString();
    }
}
