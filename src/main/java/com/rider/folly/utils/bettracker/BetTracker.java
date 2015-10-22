package com.rider.folly.utils.bettracker;

import com.rider.folly.exceptions.FollyException;
import com.rider.folly.json.enums.OrderBy;
import com.rider.folly.json.types.CurrentOrderSummary;
import com.rider.folly.operations.BettingOperations;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Ciaron Rider
 */
public class BetTracker extends Thread {
    private static final long SLEEP_PERIOD_WHEN_MONITORING = 1000;

    private static final long SLEEP_PERIOD_WHEN_NOT_MONITORING = 60 * 60 * 1000;

    private final static BetTracker instance = new BetTracker();

    private static HashMap<String, ArrayList<BetObserver>> observers;

    private static HashMap<String, CurrentOrderSummary> currentOrders;

    private static Executor executor;

    private static Lock mutex;

    private BetTracker() {
        super("Bet Tracker");

        observers = new HashMap<>();
        currentOrders = new HashMap<>();
        mutex = new ReentrantLock();
        executor = Executors.newSingleThreadExecutor((final Runnable runnable) -> new Thread(runnable, "Bet Tracker Observer Notifier"));

        start();
    }

    @Override
    public void run() {
        long sleepUntil = System.currentTimeMillis() + SLEEP_PERIOD_WHEN_NOT_MONITORING;

        while (true) {
            try {
                Thread.sleep(sleepUntil - System.currentTimeMillis());
            } catch (final InterruptedException | IllegalArgumentException exception) {
                sleepUntil = System.currentTimeMillis();
            }

            try {
                mutex.lock();

                if (!observers.isEmpty()) {
                    for (final CurrentOrderSummary summary : BettingOperations.listCurrentOrders(observers.keySet(), null, null, null, OrderBy.BY_PLACE_TIME, null, null, null).getCurrentOrders()) {
                        if (!summary.equals(currentOrders.get(summary.getBetId()))) {
                            for (final BetObserver observer : observers.get(summary.getBetId())) {
                                currentOrders.put(summary.getBetId(), summary);

                                executor.execute(() -> {
                                    observer.betStatusChanged(summary);
                                });
                            }
                        }
                    }
                }
            } catch (final FollyException exception) {
                System.err.println("Error listing current orders : " + exception.getMessage());
            } finally {
                if (observers.isEmpty()) {
                    sleepUntil += SLEEP_PERIOD_WHEN_NOT_MONITORING;
                } else {
                    sleepUntil += SLEEP_PERIOD_WHEN_MONITORING;
                }

                mutex.unlock();
            }
        }
    }

    public static void addObserver(final BetObserver observer,
                                   final String betId) {
        try {
            mutex.lock();

            if (!observers.containsKey(betId)) {
                observers.put(betId, new ArrayList<>());
            }

            observers.get(betId).add(observer);

            instance.interrupt();
        } finally {
            mutex.unlock();
        }
    }

    public static void removeObserver(final BetObserver observer,
                                      final String betId) {
        try {
            mutex.lock();

            if (observers.containsKey(betId)) {
                observers.get(betId).remove(observer);

                if (observers.get(betId).isEmpty()) {
                    observers.remove(betId);
                }
            }

            currentOrders.remove(betId);
        } finally {
            mutex.unlock();
        }
    }

    public static void removeObserver(final BetObserver observer) {
        try {
            mutex.lock();

            for (final String betId : (String[])observers.keySet().toArray()) {
                removeObserver(observer, betId);
            }
        } finally {
            mutex.unlock();
        }
    }
}
