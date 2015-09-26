package com.rider.folly.json.reponses;

import com.rider.folly.json.types.UpdateExecutionReport;

public class UpdateOrdersResponse extends Response {
    private UpdateExecutionReport result;

    public UpdateExecutionReport getResult() {
        return result;
    }
}
