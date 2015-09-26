package com.rider.folly.json.reponses;

import com.rider.folly.json.types.EventResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListEventsResponse extends Response {
    private List<EventResult> result;

    public List<EventResult> getResult() {
        if (result == null) {
            result = new ArrayList<>();
        }

        return Collections.unmodifiableList(result);
    }
}
