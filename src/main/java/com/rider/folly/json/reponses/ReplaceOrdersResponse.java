package com.rider.folly.json.reponses;

import com.rider.folly.json.types.ReplaceExecutionReport;

public class ReplaceOrdersResponse extends Response {
    private ReplaceExecutionReport result;

    public ReplaceExecutionReport getResult() {
        return result;
    }
}
