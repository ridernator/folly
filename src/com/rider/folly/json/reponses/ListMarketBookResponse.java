package com.rider.folly.json.reponses;

import com.rider.folly.json.types.MarketBook;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListMarketBookResponse extends Response {
    private List<MarketBook> result;

    public List<MarketBook> getResult() {
        if (result == null) {
            result = new ArrayList<>();
        }

        return Collections.unmodifiableList(result);
    }
}
