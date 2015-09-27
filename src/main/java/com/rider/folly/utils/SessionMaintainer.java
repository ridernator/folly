package com.rider.folly.utils;

import com.rider.folly.exceptions.FollyException;
import com.rider.folly.json.Folly;

/**
 *
 * @author Ciaron Rider
 */
public class SessionMaintainer extends Thread {
    /**
     * Time in milliseconds to sleep between keep alives
     */
    private static final long KEEP_ALIVE_SLEEP_PERIOD = 60 * 60 * 1000;

    /**
     * Time in milliseconds to sleep between login attempts
     */
    private static final long RETRY_LOGIN_SLEEP_PERIOD = 1000;

    /**
     * Time in milliseconds to sleep between checking for initial login
     */
    private static final long INITIAL_LOGIN_CHECK_PERIOD = 100;

    /**
     * True if we are logged in, false if not
     */
    private boolean loggedIn;

    public SessionMaintainer() {
        super();

        loggedIn = false;

        start();

        while (!loggedIn) {
            try {
                Thread.sleep(INITIAL_LOGIN_CHECK_PERIOD);
            } catch (final InterruptedException exception) {
                // Ignore
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            while (!loggedIn) {
                try {
                    Folly.login();

                    System.out.println("Now logged into Betfair");
                    loggedIn = true;
                } catch (final FollyException exception) {
                    System.err.println("Error logging in : \"" + exception.getMessage() + '\"');

                    try {
                        Thread.sleep(RETRY_LOGIN_SLEEP_PERIOD);
                    } catch (final InterruptedException interruptedException) {
                        // Ignore
                    }
                }
            }

            while (loggedIn) {
                try {
                    Thread.sleep(KEEP_ALIVE_SLEEP_PERIOD);
                } catch (final InterruptedException interruptedException) {
                    // Ignore
                }

                try {
                    Folly.keepAlive();
                    System.out.println("Keep alive sent and acknowledged OK");
                } catch (final FollyException exception) {
                    System.err.println("Error in keep alive : \"" + exception.getMessage() + '\"');

                    loggedIn = false;
                }
            }
        }
    }
}
