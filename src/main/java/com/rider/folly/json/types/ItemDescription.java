package com.rider.folly.json.types;

import java.util.Date;

/**
 * This object contains some text which may be useful to render a betting
 * history view. It offers no long-term warranty as to the correctness of the
 * text.
 *
 * @author Ciaron Rider
 */
public class ItemDescription {
    /**
     * The event type name, translated into the requested locale. Available at
     * EVENT_TYPE groupBy or lower.
     */
    private String eventTypeDesc;

    /**
     * The eventName, or openDate + venue, translated into the requested locale.
     * Available at EVENT groupBy or lower.
     */
    private String eventDesc;

    /**
     * The market name or racing market type ("Win", "To Be Placed (2 places)",
     * "To Be Placed (5 places)" etc) translated into the requested locale.
     * Available at MARKET groupBy or lower.
     */
    private String marketDesc;

    /**
     * The market type e.g. MATCH_ODDS, PLACE, WIN etc.
     */
    private String marketType;

    /**
     * The start time of the market (in ISO-8601 format, not translated).
     * Available at MARKET groupBy or lower.
     */
    private Date marketStartTime;

    /**
     * The runner name, maybe including the handicap, translated into the
     * requested locale. Available at BET groupBy.
     */
    private String runnerDesc;

    /**
     * The number of winners on a market. Available at BET groupBy.
     */
    private int numberOfWinners;

    /**
     * The divisor is returned for the marketType EACH_WAY only and refers to
     * the fraction of the win odds at which the place portion of an each way
     * bet is settled
     */
    private double eachWayDivisor;

    public double getEachWayDivisor() {
        return eachWayDivisor;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public String getEventTypeDesc() {
        return eventTypeDesc;
    }

    public String getMarketDesc() {
        return marketDesc;
    }

    public Date getMarketStartTime() {
        return marketStartTime;
    }

    public String getMarketType() {
        return marketType;
    }

    public int getNumberOfWinners() {
        return numberOfWinners;
    }

    public String getRunnerDesc() {
        return runnerDesc;
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

        builder.append(indentString).append("Event Type Desc   : ").append(getEventTypeDesc()).append('\n');
        builder.append(indentString).append("Event Desc        : ").append(getEventDesc()).append('\n');
        builder.append(indentString).append("Market Desc       : ").append(getMarketDesc()).append('\n');
        builder.append(indentString).append("Market Type       : ").append(getMarketType()).append('\n');
        builder.append(indentString).append("Market Start Time : ").append(getMarketStartTime()).append('\n');
        builder.append(indentString).append("Runner Desc       : ").append(getRunnerDesc()).append('\n');
        builder.append(indentString).append("Number Of Winners : ").append(getNumberOfWinners()).append('\n');
        builder.append(indentString).append("Each Way Divisor  : ").append(getEachWayDivisor()).append('\n');

        return builder.toString();
    }
}
