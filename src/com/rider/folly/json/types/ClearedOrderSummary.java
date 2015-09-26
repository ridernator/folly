package com.rider.folly.json.types;

import com.rider.folly.json.enums.BetOutcome;
import com.rider.folly.json.enums.OrderType;
import com.rider.folly.json.enums.PersistenceType;
import com.rider.folly.json.enums.Side;
import java.util.Date;

/**
 * Summary of a cleared order.
 *
 * @author Ciaron Rider
 */
public class ClearedOrderSummary {
    /**
     * The id of the event type bet on. Available at EVENT_TYPE groupBy level or
     * lower.
     */
    private String eventTypeId;

    /**
     * The id of the event bet on. Available at EVENT groupBy level or lower.
     */
    private String eventId;

    /**
     * The id of the market bet on. Available at MARKET groupBy level or lower.
     */
    private String marketId;

    /**
     * The id of the selection bet on. Available at RUNNER groupBy level or
     * lower.
     */
    private long selectionId;

    /**
     * The id of the market bet on. Available at MARKET groupBy level or lower.
     */
    private double handicap;

    /**
     * The id of the bet. Available at BET groupBy level.
     */
    private String betId;

    /**
     * The date the bet order was placed by the customer. Only available at BET
     * groupBy level.
     */
    private Date placedDate;

    /**
     * The turn in play persistence state of the order at bet placement time.
     * This field will be empty or omitted on true SP bets. Only available at
     * BET groupBy level.
     */
    private PersistenceType persistenceType;

    /**
     * The type of bet (e.g standard limited-liability Exchange bet (LIMIT), a
     * standard BSP bet (MARKET_ON_CLOSE), or a minimum-accepted-price BSP bet
     * (LIMIT_ON_CLOSE)). If the bet has a OrderType of MARKET_ON_CLOSE and a
     * persistenceType of MARKET_ON_CLOSE then it is a bet which has
     * transitioned from LIMIT to MARKET_ON_CLOSE. Only available at BET groupBy
     * level.
     */
    private OrderType orderType;

    /**
     * Whether the bet was a back or lay bet. Available at SIDE groupBy level or
     * lower.
     */
    private Side side;

    /**
     * A container for all the ancillary data and localised text valid for this
     * Item
     */
    private ItemDescription itemDescription;

    /**
     * The settlement outcome of the bet. Tri-state (WIN/LOSE/PLACE) to account
     * for Each Way bets where the place portion of the bet won but the win
     * portion lost. The profit/loss amount in this case could be positive or
     * negative depending on the price matched at. Only available at BET groupBy
     * level.
     */
    private BetOutcome betOutcome;

    /**
     * The average requested price across all settled bet orders under this
     * Item. Available at SIDE groupBy level or lower.
     */
    private double priceRequested;

    /**
     * The date and time the bet order was settled by Betfair. Available at SIDE
     * groupBy level or lower.
     */
    private Date settledDate;

    /**
     * The date and time the last bet order was matched by Betfair. Available on
     * Settled orders only.
     */
    private Date lastMatchedDate;

    /**
     * The number of actual bets within this grouping (will be 1 for BET
     * groupBy)
     */
    private int betCount;

    /**
     * The cumulative amount of commission paid by the customer across all bets
     * under this Item, in the account currency. Available at EXCHANGE,
     * EVENT_TYPE, EVENT and MARKET level groupings only.
     */
    private double commission;

    /**
     * The average matched price across all settled bets or bet fragments under
     * this Item. Available at SIDE groupBy level or lower.
     */
    private double priceMatched;

    /**
     * If true, then the matched price was affected by a reduction factor due to
     * of a runner removal from this Horse Racing market.
     */
    private boolean priceReduced;

    /**
     * The cumulative bet size that was settled as matched or voided under this
     * Item, in the account currency. Available at SIDE groupBy level or lower.
     */
    private double sizeSettled;

    /**
     * The profit or loss (negative profit) gained on this line, in the account
     * currency
     */
    private double profit;

    /**
     * The amount of the bet that was available to be matched, before
     * cancellation or lapsing, in the account currency
     */
    private double sizeCancelled;

    public int getBetCount() {
        return betCount;
    }

    public String getBetId() {
        return betId;
    }

    public BetOutcome getBetOutcome() {
        return betOutcome;
    }

    public double getCommission() {
        return commission;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventTypeId() {
        return eventTypeId;
    }

    public double getHandicap() {
        return handicap;
    }

    public ItemDescription getItemDescription() {
        return itemDescription;
    }

    public Date getLastMatchedDate() {
        return lastMatchedDate;
    }

    public String getMarketId() {
        return marketId;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public PersistenceType getPersistenceType() {
        return persistenceType;
    }

    public Date getPlacedDate() {
        return placedDate;
    }

    public double getPriceMatched() {
        return priceMatched;
    }

    public double getPriceRequested() {
        return priceRequested;
    }

    public double getProfit() {
        return profit;
    }

    public long getSelectionId() {
        return selectionId;
    }

    public Date getSettledDate() {
        return settledDate;
    }

    public Side getSide() {
        return side;
    }

    public double getSizeCancelled() {
        return sizeCancelled;
    }

    public double getSizeSettled() {
        return sizeSettled;
    }

    public boolean isPriceReduced() {
        return priceReduced;
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

        builder.append(indentString).append("Event Type Id     : ").append(getEventTypeId()).append('\n');
        builder.append(indentString).append("Event Id          : ").append(getEventId()).append('\n');
        builder.append(indentString).append("Market Id         : ").append(getMarketId()).append('\n');
        builder.append(indentString).append("Selection Id      : ").append(getSelectionId()).append('\n');
        builder.append(indentString).append("Handicap          : ").append(getHandicap()).append('\n');
        builder.append(indentString).append("Bet Id            : ").append(getBetId()).append('\n');
        builder.append(indentString).append("Placed Date       : ").append(getPlacedDate()).append('\n');
        builder.append(indentString).append("Persistence Type  : ").append(getPersistenceType()).append('\n');
        builder.append(indentString).append("Order Type        : ").append(getOrderType()).append('\n');
        builder.append(indentString).append("Side              : ").append(getSide()).append('\n');

        if (getItemDescription() == null) {
            builder.append(indentString).append("Item Description  : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Item Description  : ").append('\n').append(getItemDescription().toString(indent + Indent.INDENT_SIZE));
        }

        builder.append(indentString).append("Bet Outcome       : ").append(getBetOutcome()).append('\n');
        builder.append(indentString).append("Price Requested   : ").append(getPriceRequested()).append('\n');
        builder.append(indentString).append("Settled Date      : ").append(getSettledDate()).append('\n');
        builder.append(indentString).append("Last Matched Date : ").append(getLastMatchedDate()).append('\n');
        builder.append(indentString).append("Bet Count         : ").append(getBetCount()).append('\n');
        builder.append(indentString).append("Commission        : ").append(getCommission()).append('\n');
        builder.append(indentString).append("Price Matched     : ").append(getPriceMatched()).append('\n');
        builder.append(indentString).append("Price Reduced     : ").append(isPriceReduced()).append('\n');
        builder.append(indentString).append("Size Settled      : ").append(getSizeSettled()).append('\n');
        builder.append(indentString).append("Profit            : ").append(getProfit()).append('\n');
        builder.append(indentString).append("Size Cancelled    : ").append(getSizeCancelled()).append('\n');

        return builder.toString();
    }
}
