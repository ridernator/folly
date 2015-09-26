package com.rider.folly;

import com.rider.folly.exceptions.FollyException;
import com.rider.folly.json.Folly;
import com.rider.folly.json.enums.Wallet;
import com.rider.folly.operations.AccountOperations;

/**
 *
 * @author Ciaron Rider
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Folly.init("yourAppId", "yourUsername", "yourPassword");

        try {
            System.out.println(AccountOperations.getAccountFunds(Wallet.UK));
        } catch (final FollyException exception) {
            exception.printStackTrace();
        }

        Thread.sleep(5000);

        System.exit(0);
    }
}
