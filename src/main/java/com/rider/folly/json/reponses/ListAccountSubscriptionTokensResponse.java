package com.rider.folly.json.reponses;

import com.rider.folly.json.types.AccountSubscription;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListAccountSubscriptionTokensResponse extends Response {
    private List<AccountSubscription> result;

    public List<AccountSubscription> getResult() {
        if (result == null) {
            result = new ArrayList<>();
        }

        return Collections.unmodifiableList(result);
    }
}
