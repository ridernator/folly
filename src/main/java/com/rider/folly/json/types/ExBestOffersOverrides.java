package com.rider.folly.json.types;

import com.rider.folly.json.enums.RollupModel;

/**
 * Options to alter the default representation of best offer prices
 *
 * @author Ciaron Rider
 */
public class ExBestOffersOverrides {
    /**
     * The maximum number of prices to return on each side for each runner. If
     * unspecified defaults to 3.
     */
    private int bestPricesDepth;

    /**
     * The model to use when rolling up available sizes. If unspecified defaults
     * to STAKE rollup model with rollupLimit of minimum stake in the specified
     * currency.
     */
    private RollupModel rollupModel;

    /**
     * The volume limit to use when rolling up returned sizes. The exact
     * definition of the limit depends on the rollupModel. If no limit is
     * provided it will use minimum stake as default the value. Ignored if no
     * rollup model is specified.
     */
    private int rollupLimit;

    /**
     * Only applicable when rollupModel is MANAGED_LIABILITY. The rollup model
     * switches from being stake based to liability based at the smallest lay
     * price which is >= rollupLiabilityThreshold.service level default (TBD).
     * Not supported as yet.
     */
    private double rollupLiabilityThreshold;

    /**
     * Only applicable when rollupModel is MANAGED_LIABILITY.
     * (rollupLiabilityFactor * rollupLimit) is the minimum liabilty the user is
     * deemed to be comfortable with. After the rollupLiabilityThreshold price
     * subsequent volumes will be rolled up to minimum value such that the
     * liability >= the minimum liability.service level default (5). Not
     * supported as yet.
     */
    private int rollupLiabilityFactor;

    public int getBestPricesDepth() {
        return bestPricesDepth;
    }

    public int getRollupLiabilityFactor() {
        return rollupLiabilityFactor;
    }

    public double getRollupLiabilityThreshold() {
        return rollupLiabilityThreshold;
    }

    public int getRollupLimit() {
        return rollupLimit;
    }

    public RollupModel getRollupModel() {
        return rollupModel;
    }

    public void setBestPricesDepth(final int bestPricesDepth) {
        this.bestPricesDepth = bestPricesDepth;
    }

    public void setRollupLiabilityFactor(final int rollupLiabilityFactor) {
        this.rollupLiabilityFactor = rollupLiabilityFactor;
    }

    public void setRollupLiabilityThreshold(
            final double rollupLiabilityThreshold) {
        this.rollupLiabilityThreshold = rollupLiabilityThreshold;
    }

    public void setRollupLimit(final int rollupLimit) {
        this.rollupLimit = rollupLimit;
    }

    public void setRollupModel(final RollupModel rollupModel) {
        this.rollupModel = rollupModel;
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

        builder.append(indentString).append("Best Prices Depth          : ").append(getBestPricesDepth()).append('\n');
        builder.append(indentString).append("Rollup Model               : ").append(getRollupLimit()).append('\n');
        builder.append(indentString).append("Rollup Limit               : ").append(getRollupLimit()).append('\n');
        builder.append(indentString).append("Rollup Liability Threshold : ").append(getRollupLiabilityThreshold()).append('\n');
        builder.append(indentString).append("Rollup Liability Factor    : ").append(getRollupLiabilityFactor()).append('\n');

        return builder.toString();
    }
}
