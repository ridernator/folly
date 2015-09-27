package com.rider.folly.json.reponses;

import com.rider.folly.json.types.CountryCodeResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListCountriesResponse extends Response {
    private List<CountryCodeResult> result;

    public List<CountryCodeResult> getResult() {
        if (result == null) {
            result = new ArrayList<>();
        }

        return Collections.unmodifiableList(result);
    }
}
