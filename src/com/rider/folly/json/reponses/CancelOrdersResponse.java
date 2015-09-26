package com.rider.folly.json.reponses;

import com.rider.folly.json.types.CancelExecutionReport;

public class CancelOrdersResponse extends Response {
    private CancelExecutionReport result;

    public CancelExecutionReport getResult() {
        return result;
    }
}
