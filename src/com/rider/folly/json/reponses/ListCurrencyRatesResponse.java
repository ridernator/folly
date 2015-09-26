package com.rider.folly.json.reponses;

import com.rider.folly.json.types.CurrencyRate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListCurrencyRatesResponse extends Response {
    private List<CurrencyRate> result;

    public List<CurrencyRate> getResult() {
        if (result == null) {
            result = new ArrayList<>();
        }

        return Collections.unmodifiableList(result);
    }
}
