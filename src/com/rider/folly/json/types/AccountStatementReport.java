package com.rider.folly.json.types;

import java.util.ArrayList;
import java.util.List;

/**
 * A container representing search results.
 *
 * @author Ciaron Rider
 */
public class AccountStatementReport {
    /**
     * The list of statement items returned by your request.
     */
    private List<StatementItem> accountStatement;

    /**
     * Indicates whether there are further result items beyond this page.
     */
    private boolean moreAvailable;

    public List<StatementItem> getAccountStatement() {
        if (accountStatement == null) {
            accountStatement = new ArrayList<>();
        }

        return accountStatement;
    }

    public boolean areMoreAvailable() {
        return moreAvailable;
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

        builder.append(indentString).append("More Available     : ").append(areMoreAvailable()).append('\n');
        builder.append(indentString).append("Account Statements : ").append('\n');

        for (final StatementItem accountStatement : getAccountStatement()) {
            builder.append(accountStatement.toString(indent + Indent.INDENT_SIZE)).append('\n');
        }

        return builder.toString();
    }
}
