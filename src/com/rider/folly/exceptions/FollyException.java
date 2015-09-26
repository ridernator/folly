package com.rider.folly.exceptions;

import com.rider.folly.json.types.Error;

/**
 *
 * @author Ciaron Rider
 */
public class FollyException extends Throwable {

    private final String errorMessage;

    public FollyException(final Error error) {
        errorMessage = error.getErrorCode() + " : " + error.getMessage();
    }

    public FollyException(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}
