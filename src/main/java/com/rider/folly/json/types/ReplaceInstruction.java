package com.rider.folly.json.types;

/**
 * Instruction to replace a LIMIT or LIMIT_ON_CLOSE order at a new price.
 * Original order will be cancelled and a new order placed at the new price for
 * the remaining stake.
 *
 * @author Ciaron Rider
 */
public class ReplaceInstruction {
    /**
     * Unique identifier for the bet
     */
    private String betId;

    /**
     * The price to replace the bet at
     */
    private String newPrice;

    public String getBetId() {
        return betId;
    }

    public double getNewOdds() {
        return Double.valueOf(newPrice);
    }

    public void setBetId(final String betId) {
        this.betId = betId;
    }

    public void setNewOdds(double odds) {        
        double convertedPrice;

        if (odds < 2) {
            newPrice = String.format("%.2f", odds);
        } else if (odds <= 3) {
            convertedPrice = odds - odds % 0.02;
            newPrice = String.format("%.2f", convertedPrice);
        } else if (odds <= 4) {
            convertedPrice = odds - odds % 0.05;
            newPrice = String.format("%.2f", convertedPrice);
        } else if (odds <= 6) {
            convertedPrice = odds - odds % 0.1;
            newPrice = String.format("%.1f", convertedPrice);
        } else if (odds <= 10) {
            convertedPrice = odds - odds % 0.2;
            newPrice = String.format("%.1f", convertedPrice);
        } else if (odds <= 20) {
            convertedPrice = odds - odds % 0.5;
            newPrice = String.format("%.1f", convertedPrice);
        } else if (odds <= 30) {
            convertedPrice = odds - odds % 1.0;
            newPrice = String.format("%.0f", convertedPrice);
        } else if (odds <= 50) {
            convertedPrice = odds - odds % 2.0;
            newPrice = String.format("%.0f", convertedPrice);
        } else if (odds <= 100) {
            convertedPrice = odds - odds % 5.0;
            newPrice = String.format("%.0f", convertedPrice);
        } else {
            convertedPrice = odds - odds % 10.0;
            newPrice = String.format("%.0f", convertedPrice);
        }
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

        builder.append(indentString).append("Bet Id    : ").append(getBetId()).append('\n');
        builder.append(indentString).append("New Price : ").append(getNewOdds()).append('\n');

        return builder.toString();
    }
}
