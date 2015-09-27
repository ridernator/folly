package com.rider.folly.json.reponses;

import com.rider.folly.json.types.TimeRangeResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListTimeRangesResponse extends Response {
    private List<TimeRangeResult> result;

    public List<TimeRangeResult> getResult() {
        if (result == null) {
            result = new ArrayList<>();
        }

        return Collections.unmodifiableList(result);
    }
}
