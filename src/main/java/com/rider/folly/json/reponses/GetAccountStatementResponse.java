package com.rider.folly.json.reponses;

import com.rider.folly.json.types.AccountStatementReport;

public class GetAccountStatementResponse extends Response {
    private AccountStatementReport result;

    public AccountStatementReport getResult() {
        return result;
    }
}
