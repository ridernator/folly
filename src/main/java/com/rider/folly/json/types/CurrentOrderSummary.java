package com.rider.folly.json.types;

import com.rider.folly.json.enums.OrderStatus;
import com.rider.folly.json.enums.OrderType;
import com.rider.folly.json.enums.PersistenceType;
import com.rider.folly.json.enums.Side;
import java.util.Date;
import java.util.Objects;

/**
 * Summary of a current order.
 *
 * @author Ciaron Rider
 */
public class CurrentOrderSummary {
    /**
     * The bet ID of the original place order.
     */
    private String betId;

    /**
     * The market id the order is for.
     */
    private String marketId;

    /**
     * The selection id the order is for.
     */
    private long selectionId;

    /**
     * The handicap associated with the runner in case of Asian handicap
     * markets, null otherwise.
     */
    private double handicap;

    /**
     * The price and size of the bet.
     */
    private PriceSize priceSize;

    /**
     * Not to be confused with size. This is the liability of a given BSP bet.
     */
    private double bspLiability;

    /**
     * BACK/LAY
     */
    private Side side;

    /**
     * Either EXECUTABLE (an unmatched amount remains) or EXECUTION_COMPLETE (no
     * unmatched amount remains).
     */
    private OrderStatus status;

    /**
     * What to do with the order at turn-in-play.
     */
    private PersistenceType persistenceType;

    /**
     * BSP Order type.
     */
    private OrderType orderType;

    /**
     * The date, to the second, the bet was placed.
     */
    private Date placedDate;

    /**
     * The date, to the second, of the last matched bet fragment (where
     * applicable)
     */
    private Date matchedDate;

    /**
     * The average price matched at. Voided match fragments are removed from
     * this average calculation. The price is automatically adjusted in the
     * event of non runners being declared with applicable reduction factors.
     */
    private double averagePriceMatched;

    /**
     * The current amount of this bet that was matched.
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

    /**
     * The regulator authorisation code.
     */
    private String regulatorAuthCode;

    /**
     * The regulator Code.
     */
    private String regulatorCode;

    public double getAverageOddsMatched() {
        return averagePriceMatched;
    }

    public String getBetId() {
        return betId;
    }

    public double getBspLiability() {
        return bspLiability;
    }

    public double getHandicap() {
        return handicap;
    }

    public String getMarketId() {
        return marketId;
    }

    public Date getMatchedDate() {
        return matchedDate;
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

    public PriceSize getPriceSize() {
        return priceSize;
    }

    public String getRegulatorAuthCode() {
        return regulatorAuthCode;
    }

    public String getRegulatorCode() {
        return regulatorCode;
    }

    public long getSelectionId() {
        return selectionId;
    }

    public Side getSide() {
        return side;
    }

    public double getAmountCancelled() {
        return sizeCancelled;
    }

    public double getAmountLapsed() {
        return sizeLapsed;
    }

    public double getAmountMatched() {
        return sizeMatched;
    }

    public double getAmountRemaining() {
        return sizeRemaining;
    }

    public double getAmountVoided() {
        return sizeVoided;
    }

    public OrderStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(final Object otherObject) {
        boolean returnVal = false;

        if (otherObject != null) {
            if (otherObject instanceof CurrentOrderSummary) {
                final CurrentOrderSummary other = (CurrentOrderSummary) otherObject;

                returnVal = true;

                if (getBetId() == null) {
                    returnVal &= (other.getBetId() == null);
                } else {
                    returnVal &= (getBetId().equals(other.getBetId()));
                }

                if (getMarketId() == null) {
                    returnVal &= (other.getMarketId() == null);
                } else {
                    returnVal &= (getMarketId().equals(other.getMarketId()));
                }

                if (getMatchedDate() == null) {
                    returnVal &= (other.getMatchedDate() == null);
                } else {
                    returnVal &= (getMatchedDate().equals(other.getMatchedDate()));
                }

                if (getOrderType() == null) {
                    returnVal &= (other.getOrderType() == null);
                } else {
                    returnVal &= (getOrderType().equals(other.getOrderType()));
                }

                if (getPersistenceType() == null) {
                    returnVal &= (other.getPersistenceType() == null);
                } else {
                    returnVal &= (getPersistenceType().equals(other.getPersistenceType()));
                }

                if (getPlacedDate() == null) {
                    returnVal &= (other.getPlacedDate() == null);
                } else {
                    returnVal &= (getPlacedDate().equals(other.getPlacedDate()));
                }

                if (getPriceSize() == null) {
                    returnVal &= (other.getPriceSize() == null);
                } else {
                    returnVal &= (getPriceSize().equals(other.getPriceSize()));
                }

                if (getRegulatorAuthCode() == null) {
                    returnVal &= (other.getRegulatorAuthCode() == null);
                } else {
                    returnVal &= (getRegulatorAuthCode().equals(other.getRegulatorAuthCode()));
                }

                if (getRegulatorCode() == null) {
                    returnVal &= (other.getRegulatorCode() == null);
                } else {
                    returnVal &= (getRegulatorCode().equals(other.getRegulatorCode()));
                }

                if (getSide() == null) {
                    returnVal &= (other.getSide() == null);
                } else {
                    returnVal &= (getSide().equals(other.getSide()));
                }

                if (getStatus() == null) {
                    returnVal &= (other.getStatus() == null);
                } else {
                    returnVal &= (getStatus().equals(other.getStatus()));
                }

                returnVal &= (getBspLiability() == other.getBspLiability());
                returnVal &= (getHandicap() == other.getHandicap());
                returnVal &= (getSelectionId() == other.getSelectionId());
                returnVal &= (getAmountCancelled() == other.getAmountCancelled());
                returnVal &= (getAmountLapsed() == other.getAmountLapsed());
                returnVal &= (getAmountMatched() == other.getAmountMatched());
                returnVal &= (getAmountRemaining() == other.getAmountRemaining());
                returnVal &= (getAmountVoided() == other.getAmountVoided());
            }
        }

        return returnVal;
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
        builder.append(indentString).append("Market Id             : ").append(getMarketId()).append('\n');
        builder.append(indentString).append("Selection Id          : ").append(getSelectionId()).append('\n');
        builder.append(indentString).append("Handicap              : ").append(getHandicap()).append('\n');

        if (getPriceSize() == null) {
            builder.append(indentString).append("Price Size            : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Price Size            : ").append('\n').append(getPriceSize().toString(indent + Indent.INDENT_SIZE));
        }

        builder.append(indentString).append("BSP Liability         : ").append(getBspLiability()).append('\n');
        builder.append(indentString).append("Side                  : ").append(getSide()).append('\n');
        builder.append(indentString).append("Status                : ").append(getStatus()).append('\n');
        builder.append(indentString).append("Persistence Type      : ").append(getPersistenceType()).append('\n');
        builder.append(indentString).append("Order Type            : ").append(getOrderType()).append('\n');
        builder.append(indentString).append("Placed Date           : ").append(getPlacedDate()).append('\n');

        if (getMatchedDate() == null) {
            builder.append(indentString).append("Matched Date          : ").append("Not Matched").append('\n');
        } else {
            builder.append(indentString).append("Matched Date          : ").append(getMatchedDate()).append('\n');
        }

        builder.append(indentString).append("Average Odds Matched  : ").append(getAverageOddsMatched()).append('\n');
        builder.append(indentString).append("Amount Matched        : ").append(getAmountMatched()).append('\n');
        builder.append(indentString).append("Amount Remaining      : ").append(getAmountRemaining()).append('\n');
        builder.append(indentString).append("Amount Lapsed         : ").append(getAmountLapsed()).append('\n');
        builder.append(indentString).append("Amount Cancelled      : ").append(getAmountCancelled()).append('\n');
        builder.append(indentString).append("Amount Voided         : ").append(getAmountVoided()).append('\n');
        builder.append(indentString).append("Regulator Auth Code   : ").append(getRegulatorAuthCode()).append('\n');
        builder.append(indentString).append("Regulator Code        : ").append(getRegulatorCode()).append('\n');

        return builder.toString();
    }
}
