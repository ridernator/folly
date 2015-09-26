package com.rider.folly.utils;

public class GreenBook {
    private final double minBet;

    public GreenBook(final double minBet) {
        this.minBet = minBet;
    }

    public double getBestBack(final double layAmount,
                              final double layOdds,
                              final double backOdds) {
        return Math.max(minBet, (layAmount * layOdds) / backOdds);
    }

    public double getBestLay(final double backAmount,
                             final double backOdds,
                             final double layOdds) {
        return Math.max(minBet, (backAmount * backOdds) / layOdds);
    }

    public static void main(final String[] args) {
        GreenBook greenBook = new GreenBook(2);

        double backAmount = 2;
        double backOdds = 10;
        double layOdds = 9.6;

        System.out.printf("Lay £%4.2f @ %4.2f after £%4.2f @ %4.2f to gain £%4.2f\n", greenBook.getBestLay(backAmount, backOdds, layOdds), layOdds, backAmount, backOdds, 1.0f);
    }

}
