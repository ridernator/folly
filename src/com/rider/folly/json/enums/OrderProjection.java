/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rider.folly.json.enums;

/**
 *
 * @author Ciaron Rider
 */
public enum OrderProjection {
    /**
     * EXECUTABLE and EXECUTION_COMPLETE orders
     */
    ALL,
    /**
     * An order that has a remaining unmatched portion
     */
    EXECUTABLE,
    /**
     * An order that does not have any remaining unmatched portion
     */
    EXECUTION_COMPLETE

}
