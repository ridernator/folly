package com.rider.folly.json.reponses;

import com.rider.folly.json.types.CompetitionResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListCompetitionsResponse extends Response {
    private List<CompetitionResult> result;

    public List<CompetitionResult> getResult() {
        if (result == null) {
            result = new ArrayList<>();
        }

        return Collections.unmodifiableList(result);
    }
}
