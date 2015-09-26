package com.rider.folly.json.types;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ciaron Rider
 */
public class ExchangePrices {
    private List<PriceSize> availableToBack;

    private List<PriceSize> availableToLay;

    private List<PriceSize> tradedVolume;

    public List<PriceSize> getAvailableToBack() {
        if (availableToBack == null) {
            availableToBack = new ArrayList<>();
        }

        return availableToBack;
    }

    public List<PriceSize> getAvailableToLay() {
        if (availableToLay == null) {
            availableToLay = new ArrayList<>();
        }

        return availableToLay;
    }

    public List<PriceSize> getTradedVolume() {
        if (tradedVolume == null) {
            tradedVolume = new ArrayList<>();
        }

        return tradedVolume;
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

        builder.append(indentString).append("Available To Back : ").append('\n');

        for (final PriceSize match : getAvailableToBack()) {
            builder.append(match.toString(indent + Indent.INDENT_SIZE)).append('\n');
        }

        builder.append(indentString).append("Available To Lay  : ").append('\n');

        for (final PriceSize match : getAvailableToLay()) {
            builder.append(match.toString(indent + Indent.INDENT_SIZE)).append('\n');
        }

        builder.append(indentString).append("Traded Volume     : ").append('\n');

        for (final PriceSize match : getTradedVolume()) {
            builder.append(match.toString(indent + Indent.INDENT_SIZE)).append('\n');
        }

        return builder.toString();
    }
}
