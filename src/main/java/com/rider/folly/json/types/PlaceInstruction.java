package com.rider.folly.json.types;

import com.rider.folly.json.enums.OrderType;
import com.rider.folly.json.enums.Side;

/**
 * Instruction to place a new order
 *
 * @author Ciaron Rider
 */
public class PlaceInstruction {
    /**
     *
     */
    private OrderType orderType;

    /**
     * The selection_id.
     */
    private long selectionId;

    /**
     * The handicap associated with the runner in case of Asian handicap
     * markets, null otherwise.
     */
    private double handicap;

    /**
     * Back or Lay
     */
    private Side side;

    /**
     * A simple exchange bet for immediate execution
     */
    private LimitOrder limitOrder;

    /**
     * Bets are matched if, and only if, the returned starting price is better
     * than a specified price. In the case of back bets, LOC bets are matched if
     * the calculated starting price is greater than the specified price. In the
     * case of lay bets, LOC bets are matched if the starting price is less than
     * the specified price. If the specified limit is equal to the starting
     * price, then it may be matched, partially matched, or may not be matched
     * at all, depending on how much is needed to balance all bets against each
     * other (MOC, LOC and normal exchange bets)
     */
    private LimitOnCloseOrder limitOnCloseOrder;

    /**
     * Bets remain unmatched until the market is reconciled. They are matched
     * and settled at a price that is representative of the market at the point
     * the market is turned in-play. The market is reconciled to find a starting
     * price and MOC bets are settled at whatever starting price is returned.
     * MOC bets are always matched and settled, unless a starting price is not
     * available for the selection. Market on Close bets can only be placed
     * before the starting price is determined
     */
    private MarketOnCloseOrder marketOnCloseOrder;

    public double getHandicap() {
        return handicap;
    }

    public LimitOnCloseOrder getLimitOnCloseOrder() {
        return limitOnCloseOrder;
    }

    public LimitOrder getLimitOrder() {
        return limitOrder;
    }

    public MarketOnCloseOrder getMarketOnCloseOrder() {
        return marketOnCloseOrder;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public long getSelectionId() {
        return selectionId;
    }

    public Side getSide() {
        return side;
    }

    public void setHandicap(final double handicap) {
        this.handicap = handicap;
    }

    public void setLimitOnCloseOrder(final LimitOnCloseOrder limitOnCloseOrder) {
        this.limitOnCloseOrder = limitOnCloseOrder;
    }

    public void setLimitOrder(final LimitOrder limitOrder) {
        this.limitOrder = limitOrder;
    }

    public void setMarketOnCloseOrder(
            final MarketOnCloseOrder marketOnCloseOrder) {
        this.marketOnCloseOrder = marketOnCloseOrder;
    }

    public void setOrderType(final OrderType orderType) {
        this.orderType = orderType;
    }

    public void setSelectionId(final long selectionId) {
        this.selectionId = selectionId;
    }

    public void setSide(final Side side) {
        this.side = side;
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

        builder.append(indentString).append("Order Type            : ").append(getOrderType()).append('\n');
        builder.append(indentString).append("Selection Id          : ").append(getSelectionId()).append('\n');
        builder.append(indentString).append("Handicap              : ").append(getHandicap()).append('\n');
        builder.append(indentString).append("Side                  : ").append(getSide()).append('\n');

        if (getLimitOrder() == null) {
            builder.append(indentString).append("Limit Order           : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Limit Order       : ").append('\n').append(getLimitOrder().toString(indent + Indent.INDENT_SIZE));
        }

        if (getLimitOnCloseOrder() == null) {
            builder.append(indentString).append("Limit On Close Order  : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Limit On Close Order  : ").append('\n').append(getLimitOnCloseOrder().toString(indent + Indent.INDENT_SIZE));
        }

        if (getMarketOnCloseOrder() == null) {
            builder.append(indentString).append("Market On Close Order : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Market On Close Order : ").append('\n').append(getMarketOnCloseOrder().toString(indent + Indent.INDENT_SIZE));
        }

        return builder.toString();
    }
}
