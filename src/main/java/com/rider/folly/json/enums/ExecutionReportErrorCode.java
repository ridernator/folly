package com.rider.folly.json.enums;

/**
 *
 * @author Ciaron Rider
 */
public enum ExecutionReportErrorCode {
    /**
     * The matcher is not healthy
     */
    ERROR_IN_MATCHER,
    /**
     * The order itself has been accepted, but at least one (possibly all)
     * actions have generated errors
     */
    PROCESSED_WITH_ERRORS,
    /**
     * There is an error with an action that has caused the entire order to be
     * rejected. Check the instructionReports errorCode for the reason for the
     * rejection of the order.
     */
    BET_ACTION_ERROR,
    /**
     * Order rejected due to the account's status (suspended, inactive, dup
     * cards)
     */
    INVALID_ACCOUNT_STATE,
    /**
     * Order rejected due to the account's wallet's status
     */
    INVALID_WALLET_STATUS,
    /**
     * Account has exceeded its exposure limit or available to bet limit
     */
    INSUFFICIENT_FUNDS,
    /**
     * The account has exceed the self imposed loss limit
     */
    LOSS_LIMIT_EXCEEDED,
    /**
     * Market is suspended
     */
    MARKET_SUSPENDED,
    /**
     * Market is not open for betting. It is either not yet active, suspended or
     * closed awaiting settlement.
     */
    MARKET_NOT_OPEN_FOR_BETTING,
    /**
     * Duplicate customer reference data submitted - Please note: There is a
     * time window associated with the de-duplication of duplicate submissions
     * which is 60 second
     */
    DUPLICATE_TRANSACTION,
    /**
     * Order cannot be accepted by the matcher due to the combination of
     * actions. For example, bets being edited are not on the same market, or
     * order includes both edits and placement
     */
    INVALID_ORDER,
    /**
     * Market doesn't exist
     */
    INVALID_MARKET_ID,
    /**
     * Business rules do not allow order to be placed. You are either attempting
     * to place the order using a Delayed Application Key or from a restricted
     * jurisdiction (i.e. USA)
     */
    PERMISSION_DENIED,
    /**
     * Duplicate bet ids found
     */
    DUPLICATE_BETIDS,
    /**
     * Order hasn't been passed to matcher as system detected there will be no
     * state change
     */
    NO_ACTION_REQUIRED,
    /**
     * The requested service is unavailable
     */
    SERVICE_UNAVAILABLE,
    /**
     * The regulator rejected the order. On the Italian Exchange this error will
     * occur if more than 50 bets are sent in a single placeOrders request.
     */
    REJECTED_BY_REGULATOR,
    /**
     * A specific error code that relates to Spanish Exchange markets only which
     * indicates that the bet placed contravenes the Spanish regulatory rules
     * relating to loss chasing.
     */
    NO_CHASING

}
