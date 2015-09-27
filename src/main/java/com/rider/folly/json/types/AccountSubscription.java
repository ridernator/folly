package com.rider.folly.json.types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Application subscription details
 *
 * @author Ciaron Rider
 */
public class AccountSubscription {
    /**
     * List of subscription token details
     */
    List<SubscriptionTokenInfo> subscriptionTokens;

    /**
     * Application name
     */
    private String applicationName;

    /**
     * Application version Id
     */
    private String applicationVersionId;

    public String getApplicationName() {
        return applicationName;
    }

    public String getApplicationVersionId() {
        return applicationVersionId;
    }

    public List<SubscriptionTokenInfo> getSubscriptionTokens() {
        if (subscriptionTokens == null) {
            subscriptionTokens = new ArrayList<>();
        }

        return Collections.unmodifiableList(subscriptionTokens);
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

        builder.append(indentString).append("Application Name       : ").append(getApplicationName()).append('\n');
        builder.append(indentString).append("Application Version Id : ").append(getApplicationVersionId()).append('\n');
        builder.append(indentString).append("Subscription Tokens    : ").append('\n');

        for (final SubscriptionTokenInfo subscriptionTokenInfo : getSubscriptionTokens()) {
            builder.append(subscriptionTokenInfo.toString(indent + Indent.INDENT_SIZE)).append('\n');
        }

        return builder.toString();
    }
}
