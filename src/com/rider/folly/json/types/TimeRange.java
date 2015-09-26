package com.rider.folly.json.types;

import java.util.Date;

/**
 * TimeRange
 */
public class TimeRange {
    private Date from;

    private Date to;

    public TimeRange(final Date from,
                     final Date to) {
        this.from = from;
        this.to = to;
    }

    public final Date getFrom() {
        return from;
    }

    public final void setFrom(final Date from) {
        this.from = from;
    }

    public final Date getTo() {
        return to;
    }

    public final void setTo(final Date to) {
        this.to = to;
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

        builder.append(indentString).append("From : ").append(getFrom()).append('\n');
        builder.append(indentString).append("To   : ").append(getTo()).append('\n');

        return builder.toString();
    }
}
