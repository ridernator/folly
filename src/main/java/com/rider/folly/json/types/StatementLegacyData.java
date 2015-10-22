package com.rider.folly.json.types;

import com.rider.folly.json.enums.MarketTypeLegacy;
import java.util.Date;

/**
 * Summary of a cleared order.
 *
 * @author Ciaron Rider
 */
public class StatementLegacyData {
    /**
     * The average matched price of the bet (null if no part has been matched)
     */
    private double avgPrice;

    /**
     * The amount of the stake of your bet. (0 for commission payments or
     * deposit/withdrawals)
     */
    private double betSize;

    /**
     * Back or lay
     */
    private String betType;

    /**
     * Exchange, Market on Close SP bet, or Limit on Close SP bet.
     */
    private String betCategoryType;

    /**
     * Commission rate on market
     */
    private String commissionRate;

    /**
     * Please note: this is the Id of the market without the associated
     * exchangeId
     */
    private long eventId;

    /**
     * Event Type
     */
    private long eventTypeId;

    /**
     * Full Market Name. For card payment items, this field contains the card
     * name
     */
    private String fullMarketName;

    /**
     * The winning amount to which commission is applied.
     */
    private double grossBetAmount;

    /**
     * Market Name. For card transactions, this field indicates the type of card
     * transaction (deposit, deposit fee, or withdrawal).
     */
    private String marketName;

    /**
     * Market type. For account deposits and withdrawals, marketType is set to
     * NOT_APPLICABLE.
     */
    private MarketTypeLegacy marketType;

    /**
     * Date and time of bet placement
     */
    private Date placedDate;

    /**
     * Id of the selection (this will be the same for the same selection across
     * markets)
     */
    private long selectionId;

    /**
     * Name of the selection
     */
    private String selectionName;

    /**
     * Date and time at the bet portion was settled
     */
    private Date startDate;

    /**
     * Debit or credit
     */
    private String transactionType;

    /**
     * The unique reference Id assigned to account deposit and withdrawals.
     */
    private long transactionId;

    /**
     * Win or loss
     */
    private String winLose;

    public double getAvgOdds() {
        return avgPrice;
    }

    public String getBetCategoryType() {
        return betCategoryType;
    }

    public double getBetAmount() {
        return betSize;
    }

    public String getBetType() {
        return betType;
    }

    public String getCommissionRate() {
        return commissionRate;
    }

    public long getEventId() {
        return eventId;
    }

    public long getEventTypeId() {
        return eventTypeId;
    }

    public String getFullMarketName() {
        return fullMarketName;
    }

    public double getGrossBetAmount() {
        return grossBetAmount;
    }

    public String getMarketName() {
        return marketName;
    }

    public MarketTypeLegacy getMarketType() {
        return marketType;
    }

    public Date getPlacedDate() {
        return placedDate;
    }

    public long getSelectionId() {
        return selectionId;
    }

    public String getSelectionName() {
        return selectionName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getWinLose() {
        return winLose;
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

        builder.append(indentString).append("Average Odds      : ").append(getAvgOdds()).append('\n');
        builder.append(indentString).append("Bet Amount        : ").append(getBetAmount()).append('\n');
        builder.append(indentString).append("Bet Type          : ").append(getBetType()).append('\n');
        builder.append(indentString).append("Bet Category Type : ").append(getBetCategoryType()).append('\n');
        builder.append(indentString).append("Commission Rate   : ").append(getCommissionRate()).append('\n');
        builder.append(indentString).append("Event Id          : ").append(getEventId()).append('\n');
        builder.append(indentString).append("Event Type Id     : ").append(getEventTypeId()).append('\n');
        builder.append(indentString).append("Full Market Name  : ").append(getFullMarketName()).append('\n');
        builder.append(indentString).append("Gross Bet Amount  : ").append(getGrossBetAmount()).append('\n');
        builder.append(indentString).append("Market Name       : ").append(getMarketName()).append('\n');
        builder.append(indentString).append("Market Type       : ").append(getMarketType()).append('\n');
        builder.append(indentString).append("Placed Date       : ").append(getPlacedDate()).append('\n');
        builder.append(indentString).append("Selection Id      : ").append(getSelectionId()).append('\n');
        builder.append(indentString).append("Selection Name    : ").append(getSelectionName()).append('\n');
        builder.append(indentString).append("Start Date        : ").append(getStartDate()).append('\n');
        builder.append(indentString).append("Transaction Type  : ").append(getTransactionType()).append('\n');
        builder.append(indentString).append("Transaction Id    : ").append(getTransactionId()).append('\n');
        builder.append(indentString).append("Win Lose          : ").append(getWinLose()).append('\n');

        return builder.toString();
    }
}
