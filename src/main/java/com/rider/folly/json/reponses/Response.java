package com.rider.folly.json.reponses;

import com.rider.folly.json.types.Error;

/**
 *
 * @author Ciaron Rider
 */
public class Response {
    private float jsonrpc;

    private Error error;

    private int id;

    public int getId() {
        return id;
    }

    public float getJsonrpc() {
        return jsonrpc;
    }

    public Error getError() {
        return error;
    }

}
