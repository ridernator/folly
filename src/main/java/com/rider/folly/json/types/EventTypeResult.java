/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rider.folly.json.types;

/**
 * EventType Result
 *
 * @author Ciaron Rider
 */
public class EventTypeResult {
    /**
     * The ID identifying the Event Type
     */
    private EventType eventType;

    /**
     * Count of markets associated with this eventType
     */
    private int marketCount;

    public EventType getEventType() {
        return eventType;
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

        if (getEventType() == null) {
            builder.append(indentString).append("Event Type   : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Event Type   : ").append('\n').append(getEventType().toString(indent + Indent.INDENT_SIZE));
        }

        builder.append(indentString).append("Market Count : ").append(getMarketCount()).append('\n');

        return builder.toString();
    }
}
