package com.rider.folly.json.types;

/**
 * Describes a version of an external application
 *
 * @author Ciaron Rider
 */
public class DeveloperAppVersion {
    /**
     * The sportex user who owns the specific version of the application
     */
    private String owner;

    /**
     * The unique Id of the application version
     */
    private long versionId;

    /**
     * The version identifier string such as 1.0, 2.0. Unique for a given
     * application.
     */
    private String version;

    /**
     * The unique application key associated with this application version
     */
    private String applicationKey;

    /**
     * Indicates whether the data exposed by platform services as seen by this
     * application key is delayed or realtime.
     */
    private boolean delayData;

    /**
     * Indicates whether the application version needs explicit subscription
     */
    private boolean subscriptionRequired;

    /**
     * Indicates whether the application version needs explicit management by
     * the software owner. A value of false indicates, this is a version meant
     * for personal developer use.
     */
    private boolean ownerManaged;

    /**
     * Indicates whether the application version is currently active
     */
    private boolean active;

    public String getApplicationKey() {
        return applicationKey;
    }

    public String getOwner() {
        return owner;
    }

    public String getVersion() {
        return version;
    }

    public long getVersionId() {
        return versionId;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isDelayData() {
        return delayData;
    }

    public boolean isOwnerManaged() {
        return ownerManaged;
    }

    public boolean isSubscriptionRequired() {
        return subscriptionRequired;
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

        builder.append(indentString).append("Active                : ").append(isActive()).append('\n');
        builder.append(indentString).append("Application Key       : ").append(getApplicationKey()).append('\n');
        builder.append(indentString).append("Delay Data            : ").append(isDelayData()).append('\n');
        builder.append(indentString).append("Owner                 : ").append(getOwner()).append('\n');
        builder.append(indentString).append("Owner Managed         : ").append(isOwnerManaged()).append('\n');
        builder.append(indentString).append("Subscription Required : ").append(isSubscriptionRequired()).append('\n');
        builder.append(indentString).append("Version               : ").append(getVersion()).append('\n');
        builder.append(indentString).append("Version Id            : ").append(getVersionId()).append('\n');

        return builder.toString();
    }
}
