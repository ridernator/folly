package com.rider.folly.json;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ciaron Rider
 */
public class Request {
    private float jsonrpc = 2.0f;

    private final String method;

    private int id = 1;

    private Map<String, Object> params;

    public Request(final OperationType operationType,
                   final String methodName,
                   final Map<String, Object> parameters) {
        method = operationType.getOperationPrefix() + methodName;
        params = parameters;
    }

    public Request(final OperationType operationType,
                   final String methodName,
                   final Map<String, Object> parameters,
                   final int id) {
        this(operationType, methodName, parameters);

        this.id = id;
    }

    public Request(final OperationType operationType,
                   final String methodName,
                   final Map<String, Object> parameters,
                   final int id,
                   final float jsonVersion) {
        this(operationType, methodName, parameters, id);

        this.jsonrpc = jsonVersion;
    }

    public Request(final OperationType operationType,
                   final String methodName,
                   final Map<String, Object> parameters,
                   final float jsonVersion) {
        this(operationType, methodName, parameters);

        this.jsonrpc = jsonVersion;
    }

    public String getMethodName() {
        return method;
    }

    public int getId() {
        return id;
    }

    public float getJsonVersion() {
        return jsonrpc;
    }

    public Map<String, Object> getParameters() {
        if (params == null) {
            params = new HashMap<>();
        }

        return Collections.unmodifiableMap(params);
    }
}
