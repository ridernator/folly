package com.rider.folly.json.types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Information about a market
 *
 * @author Ciaron Rider
 */
public class MarketCatalogue {
    /**
     * The unique identifier for the market. MarketId's are prefixed with '1.'
     * or '2.' 1. = UK Exchange 2. = AUS Exchange.
     */
    private String marketId;

    /**
     * The name of the market
     */
    private String marketName;

    /**
     * The time this market starts at, only returned when the MARKET_START_TIME
     * enum is passed in the marketProjections
     */
    private Date marketStartTime;

    /**
     * Details about the market
     */
    private MarketDescription description;

    /**
     * The total amount of money matched on the market
     */
    private double totalMatched;

    /**
     * The runners (selections) contained in the market
     */
    private List<RunnerCatalog> runners;

    /**
     * The Event Type the market is contained within
     */
    private EventType eventType;

    /**
     * The competition the market is contained within. Usually only applies to
     * Football competitions
     */
    private Competition competition;

    /**
     * The event the market is contained within
     */
    private Event event;

    public Competition getCompetition() {
        return competition;
    }

    public MarketDescription getDescription() {
        return description;
    }

    public Event getEvent() {
        return event;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getMarketId() {
        return marketId;
    }

    public String getMarketName() {
        return marketName;
    }

    public Date getMarketStartTime() {
        return marketStartTime;
    }

    public List<RunnerCatalog> getRunners() {
        if (runners == null) {
            runners = new ArrayList<>();
        }

        return runners;
    }

    public double getTotalMatched() {
        return totalMatched;
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

        builder.append(indentString).append("Market Id         : ").append(getMarketId()).append('\n');
        builder.append(indentString).append("Market Name       : ").append(getMarketName()).append('\n');
        builder.append(indentString).append("Market Start Time : ").append(getMarketStartTime()).append('\n');

        if (getDescription() == null) {
            builder.append(indentString).append("Description       : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Description       : ").append('\n').append(getDescription().toString(indent + Indent.INDENT_SIZE));
        }
        builder.append(indentString).append("Total Matched     : ").append(getTotalMatched()).append('\n');
        builder.append(indentString).append("Runners           : ").append('\n');

        for (final RunnerCatalog runnerCatalog : getRunners()) {
            builder.append(runnerCatalog.toString(indent + Indent.INDENT_SIZE)).append('\n');
        }

        if (getEventType() == null) {
            builder.append(indentString).append("Event Type        : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Event Type        : ").append('\n').append(getEventType().toString(indent + Indent.INDENT_SIZE));
        }
        if (getCompetition() == null) {
            builder.append(indentString).append("Competition       : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Competition       : ").append('\n').append(getCompetition().toString(indent + Indent.INDENT_SIZE));
        }
        if (getEvent() == null) {
            builder.append(indentString).append("Event             : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Event             : ").append('\n').append(getEvent().toString(indent + Indent.INDENT_SIZE));
        }

        return builder.toString();
    }
}
