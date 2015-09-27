package com.rider.folly.json.reponses;

import com.rider.folly.json.types.MarketCatalogue;
import java.util.ArrayList;
import java.util.List;

public class ListMarketCatalogueResponse extends Response {
    private List<MarketCatalogue> result;

    public List<MarketCatalogue> getResult() {
        if (result == null) {
            result = new ArrayList<>();
        }

        return result;
    }
}
