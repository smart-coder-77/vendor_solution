package com.smart.vendor.exception;

/**
 * @author Choudhury Subham on 21-06-2022
 */
public class OrderIdNotFoundException extends RuntimeException {
    public OrderIdNotFoundException(String s) {
        super(s);
    }
}
