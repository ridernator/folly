package com.rider.folly.json.reponses;

import com.rider.folly.json.types.MarketProfitAndLoss;
import java.util.ArrayList;
import java.util.List;

public class ListMarketProfitAndLossResponse extends Response {
    private List<MarketProfitAndLoss> result;

    public List<MarketProfitAndLoss> getResult() {
        if (result == null) {
            result = new ArrayList<>();
        }

        return result;
    }
}
