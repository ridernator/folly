package com.rider.folly.json.types;

import com.rider.folly.json.enums.RunnerStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The dynamic data about runners in a market
 *
 * @author Ciaron Rider
 */
public class Runner {
    /**
     * The unique id of the runner (selection)
     */
    private long selectionId;

    /**
     * The handicap. Enter the specific handicap value (returned by RUNNER in
     * listMaketBook) if the market is an Asian handicap market.
     */
    private double handicap;

    /**
     * The status of the selection (i.e., ACTIVE, REMOVED, WINNER, LOSER,
     * HIDDEN) Runner status information is available for 90 days following
     * market settlement.
     */
    private RunnerStatus status;

    /**
     * The adjustment factor applied if the selection is removed
     */
    private double adjustmentFactor;

    /**
     * The price of the most recent bet matched on this selection
     */
    private double lastPriceTraded;

    /**
     * The total amount matched on this runner
     */
    private double totalMatched;

    /**
     * If date and time the runner was removed
     */
    private Date removalDate;

    /**
     * The BSP related prices for this runner
     */
    private StartingPrices sp;

    /**
     * The Exchange prices available for this runner
     */
    private ExchangePrices ex;

    /**
     * List of orders in the market
     */
    private List<Order> orders;

    /**
     * List of matches (i.e, orders that have been fully or partially executed)
     */
    private List<Match> matches;

    public double getAdjustmentFactor() {
        return adjustmentFactor;
    }

    public ExchangePrices getExchangePrices() {
        return ex;
    }

    public double getHandicap() {
        return handicap;
    }

    public double getLastOddsTraded() {
        return lastPriceTraded;
    }

    public List<Match> getMatches() {
        if (matches == null) {
            matches = new ArrayList<>();
        }

        return matches;
    }

    public List<Order> getOrders() {
        if (orders == null) {
            orders = new ArrayList<>();
        }

        return orders;
    }

    public Date getRemovalDate() {
        return removalDate;
    }

    public long getSelectionId() {
        return selectionId;
    }

    public StartingPrices getStartingPrices() {
        return sp;
    }

    public RunnerStatus getStatus() {
        return status;
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

        builder.append(indentString).append("Selection Id      : ").append(getSelectionId()).append('\n');
        builder.append(indentString).append("Handicap          : ").append(getHandicap()).append('\n');
        builder.append(indentString).append("Status            : ").append(getStatus()).append('\n');
        builder.append(indentString).append("Adjustment Factor : ").append(getAdjustmentFactor()).append('\n');
        builder.append(indentString).append("Last Odds Traded  : ").append(getLastOddsTraded()).append('\n');
        builder.append(indentString).append("Total Matched     : ").append(getTotalMatched()).append('\n');
        builder.append(indentString).append("Removal Date      : ").append(getRemovalDate()).append('\n');

        if (getStartingPrices() == null) {
            builder.append(indentString).append("Starting Prices   : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Starting Prices   : ").append('\n').append(getStartingPrices().toString(indent + Indent.INDENT_SIZE));
        }

        if (getExchangePrices() == null) {
            builder.append(indentString).append("Exchange Prices   : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Exchange Prices   : ").append('\n').append(getExchangePrices().toString(indent + Indent.INDENT_SIZE));
        }

        builder.append(indentString).append("Orders            : ").append('\n');

        for (final Order order : getOrders()) {
            builder.append(order.toString(indent + Indent.INDENT_SIZE)).append('\n');
        }

        builder.append(indentString).append("Matches           : ").append('\n');

        for (final Match match : getMatches()) {
            builder.append(match.toString(indent + Indent.INDENT_SIZE)).append('\n');
        }

        return builder.toString();
    }
}
