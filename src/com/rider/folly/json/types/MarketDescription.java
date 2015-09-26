package com.rider.folly.json.types;

import com.rider.folly.json.enums.MarketBettingType;
import java.util.Date;

/**
 * Market definition
 *
 * @author Ciaron Rider
 */
public class MarketDescription {
    /**
     * If 'true' the market supports 'Keep' bets if the market is to be turned
     * in-play
     */
    private boolean persistenceEnabled;

    /**
     * If 'true' the market supports Betfair SP betting
     */
    private boolean bspMarket;

    /**
     * The market start time
     */
    private Date marketTime;

    /**
     * The market suspend time
     */
    private Date suspendTime;

    /**
     * Settled time
     */
    private Date settleTime;

    /**
     * See MarketBettingType
     */
    private MarketBettingType bettingType;

    /**
     * If 'true' the market is set to turn in-play
     */
    private boolean turnInPlayEnabled;

    /**
     * Market base type
     */
    private String marketType;

    /**
     * The market regulator
     */
    private String regulator;

    /**
     * The commission rate applicable to the market
     */
    private double marketBaseRate;

    /**
     * Indicates whether or not the user's discount rate is taken into account
     * on this market. If ‘false’ all users will be charged the same commission
     * rate, regardless of discount rate.
     */
    private boolean discountAllowed;

    /**
     * The wallet to which the market belongs (UK/AUS)
     */
    private String wallet;

    /**
     * The market rules.
     */
    private String rules;

    private boolean rulesHasDate;

    /**
     * The divisor is returned for the marketType EACH_WAY only and refers to
     * the fraction of the win odds at which the place portion of an each way
     * bet is settled
     */
    private double eachWayDivisor;

    /**
     * Any additional information regarding the market
     */
    private String clarifications;

    public MarketBettingType getBettingType() {
        return bettingType;
    }

    public String getClarifications() {
        return clarifications;
    }

    public double getEachWayDivisor() {
        return eachWayDivisor;
    }

    public double getMarketBaseRate() {
        return marketBaseRate;
    }

    public Date getMarketTime() {
        return marketTime;
    }

    public String getMarketType() {
        return marketType;
    }

    public String getRegulator() {
        return regulator;
    }

    public String getRules() {
        return rules;
    }

    public Date getSettleTime() {
        return settleTime;
    }

    public Date getSuspendTime() {
        return suspendTime;
    }

    public String getWallet() {
        return wallet;
    }

    public boolean isBspMarket() {
        return bspMarket;
    }

    public boolean isDiscountAllowed() {
        return discountAllowed;
    }

    public boolean isPersistenceEnabled() {
        return persistenceEnabled;
    }

    public boolean isRulesHasDate() {
        return rulesHasDate;
    }

    public boolean isTurnInPlayEnabled() {
        return turnInPlayEnabled;
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

        builder.append(indentString).append("Persistence Enabled  : ").append(isPersistenceEnabled()).append('\n');
        builder.append(indentString).append("Bsp Market           : ").append(isBspMarket()).append('\n');
        builder.append(indentString).append("Market Time          : ").append(getMarketTime()).append('\n');
        builder.append(indentString).append("Suspend Time         : ").append(getSuspendTime()).append('\n');
        builder.append(indentString).append("Settle Time          : ").append(getSettleTime()).append('\n');
        builder.append(indentString).append("Betting Type         : ").append(getBettingType()).append('\n');
        builder.append(indentString).append("Turn In Play Enabled : ").append(isTurnInPlayEnabled()).append('\n');
        builder.append(indentString).append("Market Type          : ").append(getMarketType()).append('\n');
        builder.append(indentString).append("Regulator            : ").append(getRegulator()).append('\n');
        builder.append(indentString).append("Market Base Rate     : ").append(getMarketBaseRate()).append('\n');
        builder.append(indentString).append("Discount Allowed     : ").append(isDiscountAllowed()).append('\n');
        builder.append(indentString).append("Wallet               : ").append(getWallet()).append('\n');
        builder.append(indentString).append("Rules                : ").append(getRules()).append('\n');
        builder.append(indentString).append("Rules Has Date       : ").append(isRulesHasDate()).append('\n');
        builder.append(indentString).append("Each Way Divisor     : ").append(getEachWayDivisor()).append('\n');
        builder.append(indentString).append("Clarifications       : ").append(getClarifications()).append('\n');

        return builder.toString();
    }
}
