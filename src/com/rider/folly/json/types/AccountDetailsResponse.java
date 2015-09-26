package com.rider.folly.json.types;

import com.rider.folly.json.enums.CountryCode;
import com.rider.folly.json.enums.CurrencyParameter;

/**
 * Response for Account details.
 *
 * @author Ciaron Rider
 */
public class AccountDetailsResponse {
    /**
     * Default user currency Code. See Currency Parameters for minimum bet sizes
     * relating to each currency.
     */
    private CurrencyParameter currencyCode;

    /**
     * First Name.
     */
    private String firstName;

    /**
     * Last Name.
     */
    private String lastName;

    /**
     * Locale Code.
     */
    private String localeCode;

    /**
     * Region based on users zip/postcode (ISO 3166-1 alpha-3 format). Defaults
     * to GBR if zip/postcode cannot be identified.
     */
    private String region;

    /**
     * User Time Zone.
     */
    private String timezone;

    /**
     * User Discount Rate.
     */
    private double discountRate;

    /**
     * The Betfair points balance.
     */
    private int pointsBalance;

    /**
     * The customer's country of residence (ISO 2 Char format)
     */
    private CountryCode countryCode;

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public CurrencyParameter getCurrencyCode() {
        return currencyCode;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public int getPointsBalance() {
        return pointsBalance;
    }

    public String getRegion() {
        return region;
    }

    public String getTimezone() {
        return timezone;
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

        builder.append(indentString).append("Country Code   : ").append(getCountryCode()).append('\n');
        builder.append(indentString).append("Currency Code  : ").append(getCurrencyCode()).append('\n');
        builder.append(indentString).append("Discount Rate  : ").append(getDiscountRate()).append('\n');
        builder.append(indentString).append("First Name     : ").append(getFirstName()).append('\n');
        builder.append(indentString).append("Last Name      : ").append(getLastName()).append('\n');
        builder.append(indentString).append("Locale Code    : ").append(getLocaleCode()).append('\n');
        builder.append(indentString).append("Points Balance : ").append(getPointsBalance()).append('\n');
        builder.append(indentString).append("Region         : ").append(getRegion()).append('\n');
        builder.append(indentString).append("Timezone       : ").append(getTimezone()).append('\n');

        return builder.toString();
    }
}
