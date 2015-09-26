package com.rider.folly.json.types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Describes developer/vendor specific application
 *
 * @author Ciaron Rider
 */
public class DeveloperApp {
    /**
     * The unique name of the application
     */
    private String appName;

    /**
     * A unique id of this application
     */
    private long appId;

    /**
     * The application versions (including application keys)
     */
    private List<DeveloperAppVersion> appVersions;

    public long getAppId() {
        return appId;
    }

    public String getAppName() {
        return appName;
    }

    public List<DeveloperAppVersion> getAppVersions() {
        if (appVersions == null) {
            appVersions = new ArrayList<>();
        }

        return Collections.unmodifiableList(appVersions);
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

        builder.append(indentString).append("App Id       : ").append(getAppId()).append('\n');
        builder.append(indentString).append("App Name     : ").append(getAppName()).append('\n');
        builder.append(indentString).append("App Versions : ").append('\n');

        for (final DeveloperAppVersion developerAppVersion : getAppVersions()) {
            builder.append(developerAppVersion.toString(indent + Indent.INDENT_SIZE)).append('\n');
        }

        return builder.toString();
    }
}
