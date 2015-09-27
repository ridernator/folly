package com.rider.folly.json.types;

import com.rider.folly.json.enums.RunnerMetadatum;
import java.util.HashMap;
import java.util.Map;

/**
 * Information about the Runners (selections) in a market
 *
 * @author Ciaron Rider
 */
public class RunnerCatalog {
    /**
     * The unique id for the selection.
     */
    private long selectionId;

    /**
     * The name of the runner
     */
    private String runnerName;

    /**
     * The handicap
     */
    private double handicap;

    /**
     * The sort priority of this runner
     */
    private int sortPriority;

    /**
     * Metadata associated with the runner. For a description of this data for
     * Horse Racing, please see Runner Metadata Description
     */
    private Map<RunnerMetadatum, String> metadata;

    public double getHandicap() {
        return handicap;
    }

    public Map<RunnerMetadatum, String> getMetadata() {
        if (metadata == null) {
            metadata = new HashMap<>();
        }

        return metadata;
    }

    public String getRunnerName() {
        return runnerName;
    }

    public long getSelectionId() {
        return selectionId;
    }

    public int getSortPriority() {
        return sortPriority;
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

        builder.append(indentString).append("Selection Id : ").append(getSelectionId()).append('\n');
        builder.append(indentString).append("Runner Name : ").append(getRunnerName()).append('\n');
        builder.append(indentString).append("Handicap : ").append(getHandicap()).append('\n');
        builder.append(indentString).append("Sort Priority : ").append(getSortPriority()).append('\n');
        builder.append(indentString).append("Metadata : ").append('\n');

        for (final Map.Entry<RunnerMetadatum, String> map : getMetadata().entrySet()) {
            builder.append(indentString).append(indentString).append(map.getKey()).append(" -> ").append(map.getValue()).append('\n');
        }

        return builder.toString();
    }
}
