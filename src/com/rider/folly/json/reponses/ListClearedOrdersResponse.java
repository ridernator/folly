package com.rider.folly.json.reponses;

import com.rider.folly.json.types.ClearedOrderSummaryReport;

public class ListClearedOrdersResponse extends Response {
    private ClearedOrderSummaryReport result;

    public ClearedOrderSummaryReport getResult() {
        return result;
    }
}
