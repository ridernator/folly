package com.rider.folly.json.types;

import java.util.ArrayList;
import java.util.List;

/**
 * Profit and loss in a market
 *
 * @author Ciaron Rider
 */
public class MarketProfitAndLoss {
    /**
     * The unique identifier for the market
     */
    private String marketId;

    /**
     * The commission rate applied to P&L values. Only returned if
     * netOfCommision option is requested
     */
    private double commissionApplied;

    /**
     * Calculated profit and loss data.
     */
    private List<RunnerProfitAndLoss> profitAndLosses;

    public double getCommissionApplied() {
        return commissionApplied;
    }

    public String getMarketId() {
        return marketId;
    }

    public List<RunnerProfitAndLoss> getProfitAndLosses() {
        if (profitAndLosses == null) {
            profitAndLosses = new ArrayList<>();
        }

        return profitAndLosses;
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

        builder.append(indentString).append("Market Id          : ").append(getMarketId()).append('\n');
        builder.append(indentString).append("Commission Applied : ").append(getCommissionApplied()).append('\n');
        builder.append(indentString).append("Profit And Losses  : ").append('\n');

        for (final RunnerProfitAndLoss runnerProfitAndLoss : getProfitAndLosses()) {
            builder.append(runnerProfitAndLoss.toString(indent + Indent.INDENT_SIZE)).append('\n');
        }

        return builder.toString();
    }
}
