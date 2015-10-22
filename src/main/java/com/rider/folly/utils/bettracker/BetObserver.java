package com.rider.folly.utils.bettracker;

import com.rider.folly.json.types.CurrentOrderSummary;

/**
 *
 * @author Ciaron Rider
 */
public interface BetObserver {
    void betStatusChanged(final CurrentOrderSummary currentOrderSummary);
}
