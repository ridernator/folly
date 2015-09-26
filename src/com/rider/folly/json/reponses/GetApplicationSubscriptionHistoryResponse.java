package com.rider.folly.json.reponses;

import com.rider.folly.json.types.SubscriptionHistory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Ciaron Rider
 */
public class GetApplicationSubscriptionHistoryResponse extends Response {
    private List<SubscriptionHistory> result;

    public List<SubscriptionHistory> getResult() {
        if (result == null) {
            result = new ArrayList<>();
        }

        return Collections.unmodifiableList(result);
    }
}
