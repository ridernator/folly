package com.rider.folly.json.reponses;

import com.rider.folly.json.types.PlaceExecutionReport;

public class PlaceOrdersResponse extends Response {
    private PlaceExecutionReport result;

    public PlaceExecutionReport getResult() {
        return result;
    }
}
