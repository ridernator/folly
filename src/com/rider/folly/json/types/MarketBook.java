package com.rider.folly.json.types;

import com.rider.folly.json.enums.MarketStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The dynamic data in a market
 *
 * @author Ciaron Rider
 */
public class MarketBook {
    /**
     * The unique identifier for the market. MarketId's are prefixed with '1.'
     * or '2.' 1. = UK Exchange 2. = AUS Exchange.
     */
    private String marketId;

    /**
     * True if the data returned by listMarketBook will be delayed. The data may
     * be delayed because you are not logged in with a funded account or you are
     * using an Application Key that does not allow up to date data.
     */
    private boolean isMarketDataDelayed;

    /**
     * The status of the market, for example OPEN, SUSPENDED, CLOSED (settled),
     * etc.
     */
    private MarketStatus status;

    /**
     * The number of seconds an order is held until it is submitted into the
     * market. Orders are usually delayed when the market is in-play
     */
    private int betDelay;

    /**
     * True if the market starting price has been reconciled
     */
    private boolean bspReconciled;

    /**
     * If false, runners may be added to the market
     */
    private boolean complete;

    /**
     * True if the market is currently in play
     */
    private boolean inplay;

    /**
     * The number of selections that could be settled as winners
     */
    private int numberOfWinners;

    /**
     * The number of runners in the market
     */
    private int numberOfRunners;

    /**
     * The number of runners that are currently active. An active runner is a
     * selection available for betting
     */
    private int numberOfActiveRunners;

    /**
     * The most recent time an order was executed
     */
    private Date lastMatchTime;

    /**
     * The total amount matched
     */
    private double totalMatched;

    /**
     * The total amount of orders that remain unmatched
     */
    private double totalAvailable;

    /**
     * True if cross matching is enabled for this market.
     */
    private boolean crossMatching;

    /**
     * True if runners in the market can be voided
     */
    private boolean runnersVoidable;

    /**
     * The version of the market. The version increments whenever the market
     * status changes, for example, turning in-play, or suspended when a goal is
     * scored.
     */
    private long version;

    /**
     * Information about the runners (selections) in the market.
     */
    private List<Runner> runners;

    public int getBetDelay() {
        return betDelay;
    }

    public Date getLastMatchTime() {
        return lastMatchTime;
    }

    public String getMarketId() {
        return marketId;
    }

    public int getNumberOfActiveRunners() {
        return numberOfActiveRunners;
    }

    public int getNumberOfRunners() {
        return numberOfRunners;
    }

    public int getNumberOfWinners() {
        return numberOfWinners;
    }

    public List<Runner> getRunners() {
        if (runners == null) {
            runners = new ArrayList<>();
        }

        return runners;
    }

    public MarketStatus getStatus() {
        return status;
    }

    public double getTotalAvailable() {
        return totalAvailable;
    }

    public double getTotalMatched() {
        return totalMatched;
    }

    public long getVersion() {
        return version;
    }

    public boolean isBspReconciled() {
        return bspReconciled;
    }

    public boolean isComplete() {
        return complete;
    }

    public boolean isCrossMatching() {
        return crossMatching;
    }

    public boolean isInplay() {
        return inplay;
    }

    public boolean isRunnersVoidable() {
        return runnersVoidable;
    }

    public boolean isMarketDataDelayed() {
        return isMarketDataDelayed;
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

        builder.append(indentString).append("Market Id                : ").append(getMarketId()).append('\n');
        builder.append(indentString).append("Market Data Delayed      : ").append(isMarketDataDelayed()).append('\n');
        builder.append(indentString).append("Status                   : ").append(getStatus()).append('\n');
        builder.append(indentString).append("Bet Delay                : ").append(getBetDelay()).append('\n');
        builder.append(indentString).append("BSP Reconciled           : ").append(isBspReconciled()).append('\n');
        builder.append(indentString).append("Complete                 : ").append(isComplete()).append('\n');
        builder.append(indentString).append("In Play                  : ").append(isInplay()).append('\n');
        builder.append(indentString).append("Number Of Winners        : ").append(getNumberOfWinners()).append('\n');
        builder.append(indentString).append("Number Of Runners        : ").append(getNumberOfRunners()).append('\n');
        builder.append(indentString).append("Number Of Active Runners : ").append(getNumberOfActiveRunners()).append('\n');
        builder.append(indentString).append("Last Match Time          : ").append(getLastMatchTime()).append('\n');
        builder.append(indentString).append("Total Matched            : ").append(getTotalMatched()).append('\n');
        builder.append(indentString).append("Total Available          : ").append(getTotalAvailable()).append('\n');
        builder.append(indentString).append("Cross Matching           : ").append(isCrossMatching()).append('\n');
        builder.append(indentString).append("Runners Voidable         : ").append(isRunnersVoidable()).append('\n');
        builder.append(indentString).append("Version                  : ").append(getVersion()).append('\n');
        builder.append(indentString).append("Runners                  : ").append('\n');

        for (final Runner runner : getRunners()) {
            builder.append(runner.toString(indent + Indent.INDENT_SIZE)).append('\n');
        }

        return builder.toString();
    }
}
