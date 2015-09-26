package com.rider.folly.json.reponses;

import com.rider.folly.json.types.EventTypeResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListEventTypesResponse extends Response {
    private List<EventTypeResult> result;

    public List<EventTypeResult> getResult() {
        if (result == null) {
            result = new ArrayList<>();
        }

        return Collections.unmodifiableList(result);
    }
}
