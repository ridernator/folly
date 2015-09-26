package com.rider.folly.json.reponses;

import com.rider.folly.json.enums.Status;

public class CancelApplicationSubscriptionResponse extends Response {
    private Status result;

    public Status getResult() {
        return result;
    }
}
