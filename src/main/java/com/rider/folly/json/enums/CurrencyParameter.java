package com.rider.folly.json.enums;

/**
 *
 * @author Ciaron Rider
 */
public enum CurrencyParameter {
    GBP("UK Sterling", "£", 2, 10, 10),
    EUR("Euro", "€", 2, 15, 20),
    USD("US Dollar", "US$", 4, 15, 20),
    HKD("Hong Kong Dollars", "HK$", 25, 150, 125),
    AUD("Australian Dollar", "AUD", 5, 30, 30),
    CAD("Canadian Dollar", "CAD", 6, 25, 30),
    DKK("Danish Kroner", "DKK", 30, 150, 150),
    NOK("Norwegian Kronor", "NOK", 30, 150, 150),
    SEK("Swedish Krona", "SEK", 30, 150, 150),
    SGD("Singapore Dollar", "SGD", 6, 30, 30);

    private final String currencyName;

    private final String symbol;

    private final double minBetSize;

    private final double minDespositSize;

    private final double minBSPLiability;

    CurrencyParameter(final String currencyName,
                      final String symbol,
                      final double minBetSize,
                      final double minDespositSize,
                      final double minBSPLiability) {
        this.currencyName = currencyName;
        this.symbol = symbol;
        this.minBetSize = minBetSize;
        this.minDespositSize = minDespositSize;
        this.minBSPLiability = minBSPLiability;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public double getMinBSPLiability() {
        return minBSPLiability;
    }

    public double getMinBetSize() {
        return minBetSize;
    }

    public double getMinDespositSize() {
        return minDespositSize;
    }

    public String getSymbol() {
        return symbol;
    }
}
