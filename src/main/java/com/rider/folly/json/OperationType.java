package com.rider.folly.json;

/**
 *
 * @author Ciaron Rider
 */
public enum OperationType {
    BETTING("https://api.betfair.com/exchange/betting/json-rpc/v1", "SportsAPING/v1.0/"),
    ACCOUNTS("https://api.betfair.com/exchange/account/json-rpc/v1", "AccountAPING/v1.0/"),
    HEARTBEAT("https://api.betfair.com/exchange/heartbeat/json-rpc/v1", "HeartbeatAPING/v1.0/"),
    LOGIN("https://identitysso.betfair.com/api/login", ""),
    KEEP_ALIVE("https://identitysso.betfair.com/api/keepAlive", "");

    private final String address;

    private final String operationPrefix;

    private OperationType(final String address,
                          final String operationPrefix) {
        this.address = address;
        this.operationPrefix = operationPrefix;
    }

    public String getAddress() {
        return address;
    }

    public String getOperationPrefix() {
        return operationPrefix;
    }
}
