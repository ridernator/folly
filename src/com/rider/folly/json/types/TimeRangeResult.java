package com.rider.folly.json.types;

/**
 * TimeRange Result
 *
 * @author Ciaron Rider
 */
public class TimeRangeResult {
    /**
     * TimeRange
     */
    private TimeRange timeRange;

    /**
     * Count of markets associated with this TimeRange
     */
    private int marketCount;

    public int getMarketCount() {
        return marketCount;
    }

    public TimeRange getTimeRange() {
        return timeRange;
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

        if (getTimeRange() == null) {
            builder.append(indentString).append("Time Range   : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Time Range   : ").append('\n').append(getTimeRange().toString(indent + Indent.INDENT_SIZE));
        }

        builder.append(indentString).append("Market Count : ").append(getMarketCount()).append('\n');

        return builder.toString();
    }
}
