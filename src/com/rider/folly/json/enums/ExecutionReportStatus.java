package com.rider.folly.json.enums;

/**
 *
 * @author Ciaron Rider
 */
public enum ExecutionReportStatus {
    /**
     * Order processed successfully
     */
    SUCCESS,
    /**
     * Order failed.
     */
    FAILURE,
    /**
     * The order itself has been accepted, but at least one (possibly all)
     * actions have generated errors. This error only occurs for replaceOrders,
     * cancelOrders and updateOrders operations. The placeOrders operation will
     * not return PROCESSED_WITH_ERRORS status as it is an atomic operation.
     */
    PROCESSED_WITH_ERRORS,
    /**
     * Order timed out.
     */
    TIMEOUT

}
