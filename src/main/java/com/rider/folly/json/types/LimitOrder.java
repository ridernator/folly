package com.rider.folly.json.types;

import com.rider.folly.json.enums.PersistenceType;

/**
 * Place a new LIMIT order (simple exchange bet for immediate execution)
 *
 * @author Ciaron Rider
 */
public class LimitOrder {
    /**
     * The size of the bet. Please note: For market type EACH_WAY. The total
     * stake = size x 2
     */
    private String size;

    /**
     * The limit price
     */
    private String price;

    /**
     * What to do with the order at turn-in-play
     */
    private PersistenceType persistenceType;

    public PersistenceType getPersistenceType() {
        return persistenceType;
    }

    public double getOdds() {
        return Double.valueOf(price);
    }

    public double getAmount() {
        return Double.valueOf(size);
    }

    public void setPersistenceType(PersistenceType persistenceType) {
        this.persistenceType = persistenceType;
    }

    public void setOdds(double odds) {        
        double convertedPrice;

        if (odds < 2) {
            price = String.format("%.2f", odds);
        } else if (odds <= 3) {
            convertedPrice = odds - odds % 0.02;
            price = String.format("%.2f", convertedPrice);
        } else if (odds <= 4) {
            convertedPrice = odds - odds % 0.05;
            price = String.format("%.2f", convertedPrice);
        } else if (odds <= 6) {
            convertedPrice = odds - odds % 0.1;
            price = String.format("%.1f", convertedPrice);
        } else if (odds <= 10) {
            convertedPrice = odds - odds % 0.2;
            price = String.format("%.1f", convertedPrice);
        } else if (odds <= 20) {
            convertedPrice = odds - odds % 0.5;
            price = String.format("%.1f", convertedPrice);
        } else if (odds <= 30) {
            convertedPrice = odds - odds % 1.0;
            price = String.format("%.0f", convertedPrice);
        } else if (odds <= 50) {
            convertedPrice = odds - odds % 2.0;
            price = String.format("%.0f", convertedPrice);
        } else if (odds <= 100) {
            convertedPrice = odds - odds % 5.0;
            price = String.format("%.0f", convertedPrice);
        } else {
            convertedPrice = odds - odds % 10.0;
            price = String.format("%.0f", convertedPrice);
        }
    }

    public void setAmount(double amount) {
        size = String.format("%.2f", amount);
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

        builder.append(indentString).append("Amount           : ").append(getAmount()).append('\n');
        builder.append(indentString).append("Odds             : ").append(getOdds()).append('\n');
        builder.append(indentString).append("Persistence Type : ").append(getPersistenceType()).append('\n');

        return builder.toString();
    }
}
