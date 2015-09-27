package com.rider.folly.json.reponses;

import com.rider.folly.json.enums.LoginStatus;

/**
 *
 * @author Ciaron Rider
 */
public class LoginResponse {
    private String product;

    private String token;

    private LoginStatus status;

    // TODO make this an enum (https://api.developer.betfair.com/services/webapps/docs/plugins/viewsource/viewpagesrc.action?pageId=4392147)
    private String error;

    public String getApplicationKey() {
        return product;
    }

    public String getError() {
        return error;
    }

    public String getSessionToken() {
        return token;
    }

    public LoginStatus getStatus() {
        return status;
    }
}
