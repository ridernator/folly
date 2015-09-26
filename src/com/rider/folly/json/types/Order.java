package com.rider.folly.json.types;

import com.rider.folly.json.enums.OrderStatus;
import com.rider.folly.json.enums.OrderType;
import com.rider.folly.json.enums.PersistenceType;
import com.rider.folly.json.enums.Side;
import java.util.Date;

/**
 *
 * @author Ciaron Rider
 */
public class Order {
    /**
     *
     */
    private String betId;

    /**
     * BSP Order type.
     */
    private OrderType orderType;

    /**
     * Either EXECUTABLE (an unmatched amount remains) or EXECUTION_COMPLETE (no
     * unmatched amount remains).
     */
    private OrderStatus status;

    /**
     * What to do with the order at turn-in-play
     */
    private PersistenceType persistenceType;

    /**
     * Indicates if the bet is a Back or a LAY
     */
    private Side side;

    /**
     * The price of the bet.
     */
    private double price;

    /**
     * The size of the bet.
     */
    private double size;

    /**
     * Not to be confused with size. This is the liability of a given BSP bet.
     */
    private double bspLiability;

    /**
     * The date, to the second, the bet was placed.
     */
    private Date placedDate;

    /**
     * The average price matched at. Voided match fragments are removed from
     * this average calculation. For MARKET_ON_CLOSE BSP bets this reports the
     * matched SP price following the SP reconciliation process.
     */
    private double avgPriceMatched;

    /**
     * The current amount of this bet that is unmatched.
     */
    private double sizeMatched;

    /**
     * The current amount of this bet that is unmatched.
     */
    private double sizeRemaining;

    /**
     * The current amount of this bet that was lapsed.
     */
    private double sizeLapsed;

    /**
     * The current amount of this bet that was cancelled.
     */
    private double sizeCancelled;

    /**
     * The current amount of this bet that was voided.
     */
    private double sizeVoided;

    public double getAveragePriceMatched() {
        return avgPriceMatched;
    }

    public String getBetId() {
        return betId;
    }

    public double getBspLiability() {
        return bspLiability;
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

    public double getPrice() {
        return price;
    }

    public Side getSide() {
        return side;
    }

    public double getSize() {
        return size;
    }

    public double getSizeCancelled() {
        return sizeCancelled;
    }

    public double getSizeLapsed() {
        return sizeLapsed;
    }

    public double getSizeMatched() {
        return sizeMatched;
    }

    public double getSizeRemaining() {
        return sizeRemaining;
    }

    public double getSizeVoided() {
        return sizeVoided;
    }

    public OrderStatus getStatus() {
        return status;
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

        builder.append(indentString).append("Bet Id                : ").append(getBetId()).append('\n');
        builder.append(indentString).append("Order Type            : ").append(getOrderType()).append('\n');
        builder.append(indentString).append("Status                : ").append(getStatus()).append('\n');
        builder.append(indentString).append("Persistence Type      : ").append(getPersistenceType()).append('\n');
        builder.append(indentString).append("Side                  : ").append(getSide()).append('\n');
        builder.append(indentString).append("Price                 : ").append(getPrice()).append('\n');
        builder.append(indentString).append("Size                  : ").append(getSize()).append('\n');
        builder.append(indentString).append("BSP Liability         : ").append(getBspLiability()).append('\n');
        builder.append(indentString).append("Placed Date           : ").append(getPlacedDate()).append('\n');
        builder.append(indentString).append("Average Price Matched : ").append(getAveragePriceMatched()).append('\n');
        builder.append(indentString).append("Size Matched          : ").append(getSizeMatched()).append('\n');
        builder.append(indentString).append("Size Remaining        : ").append(getSizeRemaining()).append('\n');
        builder.append(indentString).append("Size Lapsed           : ").append(getSizeLapsed()).append('\n');
        builder.append(indentString).append("Size Cancelled        : ").append(getSizeCancelled()).append('\n');
        builder.append(indentString).append("Size Voided           : ").append(getSizeVoided()).append('\n');

        return builder.toString();
    }
}
