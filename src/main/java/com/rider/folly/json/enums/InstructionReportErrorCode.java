package com.rider.folly.json.enums;

/**
 *
 * @author Ciaron Rider
 */
public enum InstructionReportErrorCode {
    /**
     * Bet size is invalid for your currency or your regulator
     */
    INVALID_BET_SIZE,
    /**
     * Runner does not exist, includes vacant traps in greyhound racing
     */
    INVALID_RUNNER,
    /**
     * Bet cannot be cancelled or modified as it has already been taken or has
     * been cancelled/lapsed Includes attempts to cancel/modify market on close
     * BSP bets and cancelling limit on close BSP bets
     */
    BET_TAKEN_OR_LAPSED,
    /**
     * No result was received from the matcher in a timeout configured for the
     * system
     */
    BET_IN_PROGRESS,
    /**
     * Runner has been removed from the event
     */
    RUNNER_REMOVED,
    /**
     * Attempt to edit a bet on a market that has closed.
     */
    MARKET_NOT_OPEN_FOR_BETTING,
    /**
     * The action has caused the account to exceed the self imposed loss limit
     */
    LOSS_LIMIT_EXCEEDED,
    /**
     * Market now closed to bsp betting. Turned in-play or has been reconciled
     */
    MARKET_NOT_OPEN_FOR_BSP_BETTING,
    /**
     * Attempt to edit down the price of a bsp limit on close lay bet, or edit
     * up the price of a limit on close back bet
     */
    INVALID_PRICE_EDIT,
    /**
     * Odds not on price ladder - either edit or placement
     */
    INVALID_ODDS,
    /**
     * Insufficient funds available to cover the bet action. Either the exposure
     * limit or available to bet limit would be exceeded
     */
    INSUFFICIENT_FUNDS,
    /**
     * Invalid persistence type for this market, e.g. KEEP for a non bsp market
     */
    INVALID_PERSISTENCE_TYPE,
    /**
     * A problem with the matcher prevented this action completing successfully
     */
    ERROR_IN_MATCHER,
    /**
     * The order contains a back and a lay for the same runner at overlapping
     * prices. This would guarantee a self match. This also applies to BSP limit
     * on close bets
     */
    INVALID_BACK_LAY_COMBINATION,
    /**
     * The action failed because the parent order failed
     */
    ERROR_IN_ORDER,
    /**
     * Bid type is mandatory
     */
    INVALID_BID_TYPE,
    /**
     * Bet for id supplied has not been found
     */
    INVALID_BET_ID,
    /**
     * Bet cancelled but replacement bet was not placed
     */
    CANCELLED_NOT_PLACED,
    /**
     * Action failed due to the failure of a action on which this action is
     * dependent
     */
    RELATED_ACTION_FAILED,
    /**
     * The action does not result in any state change. eg changing a persistence
     * to it's current value
     */
    NO_ACTION_REQUIRED

}
