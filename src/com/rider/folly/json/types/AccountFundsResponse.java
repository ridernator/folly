package com.rider.folly.json.types;

/**
 * Response for retrieving available to bet.
 */
public class AccountFundsResponse {
    /**
     * Amount available to bet. (UK & AUS)
     */
    private double availableToBetBalance;

    /**
     * Current exposure. (UK & AUS)
     */
    private double exposure;

    /**
     * Sum of retained commission. (UK & AUS)
     */
    private double retainedCommission;

    /**
     * Exposure limit. (UK & AUS)
     */
    private double exposureLimit;

    /**
     * User Discount Rate. (UK only)
     */
    private double discountRate;

    /**
     * The Betfair points balance
     */
    private int pointsBalance;

    public double getAvailableToBetBalance() {
        return availableToBetBalance;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public double getExposure() {
        return exposure;
    }

    public double getExposureLimit() {
        return exposureLimit;
    }

    public int getPointsBalance() {
        return pointsBalance;
    }

    public double getRetainedCommission() {
        return retainedCommission;
    }

    public void setAvailableToBetBalance(final double availableToBetBalance) {
        this.availableToBetBalance = availableToBetBalance;
    }

    public void setDiscountRate(final double discountRate) {
        this.discountRate = discountRate;
    }

    public void setExposure(final double exposure) {
        this.exposure = exposure;
    }

    public void setExposureLimit(final double exposureLimit) {
        this.exposureLimit = exposureLimit;
    }

    public void setPointsBalance(final int pointsBalance) {
        this.pointsBalance = pointsBalance;
    }

    public void setRetainedCommission(final double retainedCommission) {
        this.retainedCommission = retainedCommission;
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

        builder.append(indentString).append("Available To Bet Balance : ").append(getAvailableToBetBalance()).append('\n');
        builder.append(indentString).append("Exposure                 : ").append(getExposure()).append('\n');
        builder.append(indentString).append("Retained Commission      : ").append(getRetainedCommission()).append('\n');
        builder.append(indentString).append("Exposure Limit           : ").append(getExposureLimit()).append('\n');
        builder.append(indentString).append("Discount Rate            : ").append(getDiscountRate()).append('\n');
        builder.append(indentString).append("Points Balance           : ").append(getPointsBalance()).append('\n');

        return builder.toString();
    }
}
