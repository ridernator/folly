package com.rider.folly.json.reponses;

import com.rider.folly.json.types.MarketTypeResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListMarketTypesResponse extends Response {
    private List<MarketTypeResult> result;

    public List<MarketTypeResult> getResult() {
        if (result == null) {
            result = new ArrayList<>();
        }

        return Collections.unmodifiableList(result);
    }
}
