package com.rider.folly.json.types;

import java.util.ArrayList;
import java.util.List;

/**
 * A container representing search results.
 *
 * @author Ciaron Rider
 */
public class CurrentOrderSummaryReport {
    /**
     * The list of current orders returned by your query. This will be a valid
     * list (i.e. empty or non-empty but never 'null').
     */
    private List<CurrentOrderSummary> currentOrders;

    /**
     * Indicates whether there are further result items beyond this page. Note
     * that underlying data is highly time-dependent and the subsequent search
     * orders query might return an empty result.
     */
    private boolean moreAvailable;

    public List<CurrentOrderSummary> getCurrentOrders() {
        if (currentOrders == null) {
            currentOrders = new ArrayList<>();
        }

        return currentOrders;
    }

    public boolean isMoreAvailable() {
        return moreAvailable;
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

        builder.append(indentString).append("Current Orders : ").append('\n');

        for (final CurrentOrderSummary currentOrderSummary : getCurrentOrders()) {
            builder.append(currentOrderSummary.toString(indent + Indent.INDENT_SIZE)).append('\n');
        }

        builder.append(indentString).append("More Available : ").append(isMoreAvailable()).append('\n');

        return builder.toString();
    }
}
