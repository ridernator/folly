package com.rider.folly.json.types;

import com.rider.folly.json.enums.PriceData;
import java.util.HashSet;
import java.util.Set;

/**
 * Selection criteria of the returning price data
 *
 * @author Ciaron Rider
 */
public class PriceProjection {
    /**
     * The basic price data you want to receive in the response.
     */
    private Set<PriceData> priceData;

    /**
     * Options to alter the default representation of best offer prices
     * Applicable to EX_BEST_OFFERS priceData selection
     */
    private ExBestOffersOverrides exBestOffersOverrides;

    /**
     * Indicates if the returned prices should include virtual prices.
     * Applicable to EX_BEST_OFFERS and EX_ALL_OFFERS priceData selections,
     * default value is false.
     */
    private boolean virtualise;

    /**
     * Indicates if the volume returned at each price point should be the
     * absolute value or a cumulative sum of volumes available at the price and
     * all better prices. If unspecified defaults to false. Applicable to
     * EX_BEST_OFFERS and EX_ALL_OFFERS price projections. Not supported as yet.
     */
    private boolean rolloverStakes;

    public ExBestOffersOverrides getExBestOffersOverrides() {
        return exBestOffersOverrides;
    }

    public Set<PriceData> getPriceData() {
        if (priceData == null) {
            priceData = new HashSet<>();
        }

        return priceData;
    }

    public boolean isRolloverStakes() {
        return rolloverStakes;
    }

    public boolean isVirtualise() {
        return virtualise;
    }

    public void addPriceData(final PriceData priceData) {
        if (this.priceData == null) {
            this.priceData = new HashSet<>();
        }

        this.priceData.add(priceData);
    }

    public void setExBestOffersOverrides(
            final ExBestOffersOverrides exBestOffersOverrides) {
        this.exBestOffersOverrides = exBestOffersOverrides;
    }

    public void setRolloverStakes(final boolean rolloverStakes) {
        this.rolloverStakes = rolloverStakes;
    }

    public void setVirtualise(final boolean virtualise) {
        this.virtualise = virtualise;
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

        builder.append(indentString).append("Price Data               : ").append('\n');

        for (final PriceData priceData : getPriceData()) {
            builder.append(indentString).append(indentString).append(priceData).append('\n');
        }

        if (getExBestOffersOverrides() == null) {
            builder.append(indentString).append("Ex Best Offers Overrides       : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Ex Best Offers Overrides : ").append('\n').append(getExBestOffersOverrides().toString(indent + Indent.INDENT_SIZE));
        }

        builder.append(indentString).append("Virtualise               : ").append(isVirtualise()).append('\n');
        builder.append(indentString).append("Rollover Stakes          : ").append(isRolloverStakes()).append('\n');

        return builder.toString();
    }
}
