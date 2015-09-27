package com.rider.folly.json.types;

/**
 * EventType
 *
 * @author Ciaron Rider
 */
public class EventType {
    /**
     * id
     */
    private String id;

    /**
     * name
     */
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString(final int indent) {
        final StringBuilder builder = new StringBuilder();
        String indentString = "";

        for (int index = 0; index < indent; index++) {
            indentString += ' ';
        }

        builder.append(indentString).append("Id   : ").append(getId()).append('\n');
        builder.append(indentString).append("Name : ").append(getName()).append('\n');

        return builder.toString();
    }
}
