package com.smart.vendor.exception;

/**
 * @author Choudhury Subham on 21-06-2022
 */
public class OrderNotSavedException extends RuntimeException {
    public OrderNotSavedException(String s) {
        super(s);
    }
}
