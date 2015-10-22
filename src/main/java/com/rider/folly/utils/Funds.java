package com.rider.folly.utils;

import com.rider.folly.exceptions.FollyException;
import com.rider.folly.operations.AccountOperations;
import com.rider.folly.json.enums.Wallet;
import com.rider.folly.json.types.AccountFundsResponse;
import java.text.DecimalFormat;

/**
 *
 * @author Ciaron Rider
 */
public class Funds {
    private static final long SLEEP_PERIOD = 30 * 1000;

    private final DecimalFormat formatter = new DecimalFormat("0.00");

    /**
     * Amount available to bet. (UK & AUS)
     */
    private double availableToBetBalance;

    /**
     * Current exposure. (UK & AUS)
     */
    private double exposure;

    /**
     * Sum of retained commission. (UK & AUS)
     */
    private double retainedCommission;

    /**
     * Exposure limit. (UK & AUS)
     */
    private double exposureLimit;

    /**
     * User Discount Rate. (UK only)
     */
    private double discountRate;

    /**
     * The Betfair points balance
     */
    private int pointsBalance;

    private final static Funds instance = new Funds();

    public static void start() {
        Funds.getAvailableToBetBalance();
    }

    private Funds() {
        new Thread("Funds") {
            @Override
            public void run() {
                long sleepUntil = System.currentTimeMillis() + SLEEP_PERIOD;
                AccountFundsResponse response;
                boolean somethingHasChanged;

                while (true) {
                    somethingHasChanged = false;

                    try {
                        synchronized (instance) {
                            response = AccountOperations.getAccountFunds(Wallet.UK);

                            if (response == null) {
                                System.err.println("Failed to get funds : Call returned null");
                            } else {
                                if (availableToBetBalance != response.getAvailableToBetBalance()) {
                                    availableToBetBalance = response.getAvailableToBetBalance();
                                    somethingHasChanged = true;
                                }

                                if (exposure != response.getExposure()) {
                                    exposure = response.getExposure();
                                    somethingHasChanged = true;
                                }

                                if (retainedCommission != response.getRetainedCommission()) {
                                    retainedCommission = response.getRetainedCommission();
                                    somethingHasChanged = true;
                                }

                                if (exposureLimit != response.getExposureLimit()) {
                                    exposureLimit = response.getExposureLimit();
                                    somethingHasChanged = true;
                                }

                                if (discountRate != response.getDiscountRate()) {
                                    discountRate = response.getDiscountRate();
                                    somethingHasChanged = true;
                                }

                                if (pointsBalance != response.getPointsBalance()) {
                                    pointsBalance = response.getPointsBalance();
                                    somethingHasChanged = true;
                                }
                            }
                        }

                        if (somethingHasChanged) {
                            System.out.println("Funds : £"
                                    + formatter.format(getAvailableToBetBalance() - getExposure())
                                    + (Math.abs(getExposure()) == 0 ? "" : "(£" + formatter.format(Math.abs(getExposure())) + " in play)"));
                        }
                    } catch (final FollyException exception) {
                        System.err.println("Failed to get funds : \"" + exception.getMessage() + '\"');
                    }

                    try {
                        Thread.sleep(sleepUntil - System.currentTimeMillis());
                    } catch (final InterruptedException exception) {
                        // Ignore
                    }

                    sleepUntil += SLEEP_PERIOD;
                }
            }
        }.start();
    }

    public static double getAvailableToBetBalance() {
        synchronized (instance) {
            return instance.availableToBetBalance;
        }
    }

    public static double getDiscountRate() {
        synchronized (instance) {
            return instance.discountRate;
        }
    }

    public static double getExposure() {
        synchronized (instance) {
            return instance.exposure;
        }
    }

    public static double getExposureLimit() {
        synchronized (instance) {
            return instance.exposureLimit;
        }
    }

    public static int getPointsBalance() {
        synchronized (instance) {
            return instance.pointsBalance;
        }
    }

    public static double getRetainedCommission() {
        synchronized (instance) {
            return instance.retainedCommission;
        }
    }
}
