package com.rider.folly.json.types;

/**
 *
 * @author Ciaron Rider
 */
public class Error {
    private int code;

    private String message;

    public Error(final int code,
                 final String message) {
        this.code = code;
        this.message = message;
    }

    public int getErrorCode() {
        return code;
    }

    public String getMessage() {
        return message;
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

        builder.append(indentString).append("Code    : ").append(getErrorCode()).append('\n');
        builder.append(indentString).append("Message : ").append(getMessage()).append('\n');

        return builder.toString();
    }
}
