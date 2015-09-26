package com.rider.folly.json.types;

/**
 * Event Result
 *
 * @author Ciaron Rider
 */
public class EventResult {
    /**
     * Event
     */

    private Event event;

    /**
     * Count of markets associated with this event
     */
    private int marketCount;

    public Event getEvent() {
        return event;
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

        if (getEvent() == null) {
            builder.append(indentString).append("Event        : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Event        : ").append('\n').append(getEvent().toString(indent + Indent.INDENT_SIZE));
        }

        builder.append(indentString).append("Market Count : ").append(getMarketCount()).append('\n');

        return builder.toString();
    }
}
