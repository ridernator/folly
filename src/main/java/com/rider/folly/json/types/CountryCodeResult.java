package com.rider.folly.json.types;

import com.rider.folly.json.enums.CountryCode;

/**
 * CountryCode Result
 *
 * @author Ciaron Rider
 */
public class CountryCodeResult {
    /**
     * The ISO-2 code for the event. A list of ISO-2 codes is available via
     * http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2
     */
    private CountryCode countryCode;

    /**
     * Count of markets associated with this Country Code
     */
    private int marketCount;

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public int getMarketCount() {
        return marketCount;
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

        builder.append(indentString).append("Country Code : ").append(getCountryCode()).append('\n');
        builder.append(indentString).append("Market Count : ").append(getMarketCount()).append('\n');

        return builder.toString();
    }
}
