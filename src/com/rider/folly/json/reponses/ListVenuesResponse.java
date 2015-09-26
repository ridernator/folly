package com.rider.folly.json.reponses;

import com.rider.folly.json.types.VenueResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListVenuesResponse extends Response {
    private List<VenueResult> result;

    public List<VenueResult> getResult() {
        if (result == null) {
            result = new ArrayList<>();
        }

        return Collections.unmodifiableList(result);
    }
}
