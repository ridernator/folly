package com.rider.folly.json.reponses;

import com.rider.folly.json.types.CurrentOrderSummaryReport;

public class ListCurrentOrdersResponse extends Response {
    private CurrentOrderSummaryReport result;

    public CurrentOrderSummaryReport getResult() {
        return result;
    }
}
