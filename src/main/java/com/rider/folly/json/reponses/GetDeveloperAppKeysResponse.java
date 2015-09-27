package com.rider.folly.json.reponses;

import com.rider.folly.json.types.DeveloperApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetDeveloperAppKeysResponse extends Response {
    private List<DeveloperApp> result;

    public List<DeveloperApp> getResult() {
        if (result == null) {
            result = new ArrayList<>();
        }

        return Collections.unmodifiableList(result);
    }
}
