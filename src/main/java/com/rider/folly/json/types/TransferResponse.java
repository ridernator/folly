package com.rider.folly.json.types;

/**
 * Transfer operation response
 */
public class TransferResponse {
    /**
     * The id of the transfer transaction that will be used in tracking the
     * transfers between the wallets
     */
    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString(final int indent) {
        final StringBuilder builder = new StringBuilder();
        String indentString = "";

        for (int indentIndex = 0; indentIndex < indent; indentIndex++) {
            indentString += ' ';
        }

        builder.append(indentString).append("Transaction Id : ").append(getTransactionId()).append('\n');

        return builder.toString();
    }
}
