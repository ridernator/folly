package com.rider.folly.json.types;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about the Betfair Starting Price. Only available in BSP markets
 *
 * @author Ciaron Rider
 */
public class StartingPrices {
    /**
     * What the starting price would be if the market was reconciled now taking
     * into account the SP bets as well as unmatched exchange bets on the same
     * selection in the exchange. This data is cached and update every 60
     * seconds. Please note: Type Double may contain numbers, INF, -INF, and
     * NaN.
     */
    private double nearPrice;

    /**
     * What the starting price would be if the market was reconciled now taking
     * into account only the currently place SP bets. The Far Price is not as
     * complicated but not as accurate and only accounts for money on the
     * exchange at SP. This data is cached and updated every 60 seconds. Please
     * note: Type Double may contain numbers, INF, -INF, and NaN.
     */
    private double farPrice;

    /**
     * The total amount of back bets matched at the actual Betfair Starting
     * Price.
     */
    private List<PriceSize> backStakeTaken;

    /**
     * The lay amount matched at the actual Betfair Starting Price.
     */
    private List<PriceSize> layLiabilityTaken;

    /**
     * The final BSP price for this runner. Only available for a BSP market that
     * has been reconciled.
     */
    private double actualSP;

    public double getActualSP() {
        return actualSP;
    }

    public List<PriceSize> getBackStakeTaken() {
        if (backStakeTaken == null) {
            backStakeTaken = new ArrayList<>();
        }

        return backStakeTaken;
    }

    public double getFarPrice() {
        return farPrice;
    }

    public List<PriceSize> getLayLiabilityTaken() {
        if (layLiabilityTaken == null) {
            layLiabilityTaken = new ArrayList<>();
        }

        return layLiabilityTaken;
    }

    public double getNearPrice() {
        return nearPrice;
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

        builder.append(indentString).append("Near Price          : ").append(getNearPrice()).append('\n');
        builder.append(indentString).append("Far Price           : ").append(getFarPrice()).append('\n');
        builder.append(indentString).append("Back Stake Taken    : ").append('\n');

        for (final PriceSize priceSize : getBackStakeTaken()) {
            builder.append(priceSize.toString(indent + Indent.INDENT_SIZE)).append('\n');
        }

        builder.append(indentString).append("Lay Liability Taken : ").append('\n');

        for (final PriceSize priceSize : getLayLiabilityTaken()) {
            builder.append(priceSize.toString(indent + Indent.INDENT_SIZE)).append('\n');
        }

        builder.append(indentString).append("Actual SP           : ").append(getActualSP()).append('\n');

        return builder.toString();
    }
}
