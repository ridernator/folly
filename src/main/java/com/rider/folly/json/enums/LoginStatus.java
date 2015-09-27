package com.rider.folly.json.enums;

/**
 *
 * @author Ciaron Rider
 */
public enum LoginStatus {
    /**
     * Success!
     */
    SUCCESS,
    /**
     * Access is limited (e.g. accounts can login but can't bet due to account
     * suspension), product session will be provided.
     */
    LIMITED_ACCESS,
    /**
     * Login is restricted (in case of indirection point this is what will be
     * returned), product session will not be provided.
     */
    LOGIN_RESTRICTED,
    /**
     * All other cases are treated as errors, product session will not be
     * provided.
     */
    FAIL

}
