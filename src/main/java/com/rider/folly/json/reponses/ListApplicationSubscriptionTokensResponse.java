package com.rider.folly.json.reponses;

import com.rider.folly.json.types.ApplicationSubscription;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListApplicationSubscriptionTokensResponse extends Response {
    private List<ApplicationSubscription> result;

    public List<ApplicationSubscription> getResult() {
        if (result == null) {
            result = new ArrayList<>();
        }

        return Collections.unmodifiableList(result);
    }
}
