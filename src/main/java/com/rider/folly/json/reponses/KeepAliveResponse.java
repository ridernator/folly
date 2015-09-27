package com.rider.folly.json.reponses;

import com.rider.folly.json.enums.KeepAliveError;
import com.rider.folly.json.enums.KeepAliveStatus;
import com.rider.folly.json.enums.LoginStatus;

/**
 *
 * @author Ciaron Rider
 */
public class KeepAliveResponse {
    private String product;

    private String token;

    private KeepAliveStatus status;

    private KeepAliveError error;

    public String getApplicationKey() {
        return product;
    }

    public KeepAliveError getError() {
        return error;
    }

    public String getSessionToken() {
        return token;
    }

    public KeepAliveStatus getStatus() {
        return status;
    }
}
