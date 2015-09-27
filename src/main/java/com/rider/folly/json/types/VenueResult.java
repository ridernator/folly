package com.rider.folly.json.types;

/**
 * Venue Result
 *
 * @author Ciaron Rider
 */
public class VenueResult {
    /**
     * Venue
     */
    private String venue;

    /**
     * Count of markets associated with this Venue
     */
    private int marketCount;

    public int getMarketCount() {
        return marketCount;
    }

    public String getVenue() {
        return venue;
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

        builder.append(indentString).append("Venue        : ").append(getVenue()).append('\n');
        builder.append(indentString).append("Market Count : ").append(getMarketCount()).append('\n');

        return builder.toString();
    }
}
