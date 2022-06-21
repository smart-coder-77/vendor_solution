package com.smart.vendor.exception;

/**
 * @author Choudhury Subham on 21-06-2022
 */
public class ProductNotSavedException extends RuntimeException{
    public ProductNotSavedException(String product_not_saved) {
        super(product_not_saved);
    }

}
