package com.smart.vendor.exception;

/**
 * @author Choudhury Subham on 21-06-2022
 */
public class ProductIdNotFoundException extends RuntimeException {

    public ProductIdNotFoundException(String s) {
        super(s);
    }
}
