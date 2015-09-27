package com.rider.folly.json.types;

/**
 * Currency rate
 *
 * @author Ciaron Rider
 */
public class CurrencyRate {
    /**
     * Three letter ISO 4217 code
     */
    private String currencyCode;

    /**
     * Exchange rate for the currency specified in the request
     */
    private double rate;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public double getRate() {
        return rate;
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

        builder.append(indentString).append("Currency Code : ").append(getCurrencyCode()).append('\n');
        builder.append(indentString).append("Rate          : ").append(getRate()).append('\n');

        return builder.toString();
    }
}
