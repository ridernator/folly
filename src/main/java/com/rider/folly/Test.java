package com.rider.folly;

import com.rider.folly.exceptions.FollyException;
import com.rider.folly.json.Folly;
import com.rider.folly.json.enums.OrderBy;
import com.rider.folly.json.enums.OrderProjection;
import com.rider.folly.json.enums.SortDir;
import com.rider.folly.json.enums.Wallet;
import com.rider.folly.json.types.CurrentOrderSummary;
import com.rider.folly.operations.AccountOperations;
import com.rider.folly.operations.BettingOperations;
import com.rider.folly.utils.bettracker.BetObserver;
import com.rider.folly.utils.bettracker.BetTracker;

/**
 *
 * @author Ciaron Rider
 */
public class Test {
    public static void main(final String[] args) throws InterruptedException {
        Folly.init("yourAppId", "yourUsername", "yourPassword");
        
        try {
            System.out.println(AccountOperations.getAccountFunds(Wallet.UK));

            System.out.println(BettingOperations.listCurrentOrders(null, null, OrderProjection.ALL, null, OrderBy.BY_BET, SortDir.EARLIEST_TO_LATEST, null, null));
        } catch (final FollyException exception) {
            exception.printStackTrace();
        }
        
        Thread.sleep(5000);

        BetObserver observer = new BetObserver() {

            @Override
            public void betStatusChanged(
                    final CurrentOrderSummary currentOrderSummary) {
                System.out.println("=======================================\n"+currentOrderSummary);
            }
        };

        //BetTracker.addObserver(observer, "55974406551");
    }
}
