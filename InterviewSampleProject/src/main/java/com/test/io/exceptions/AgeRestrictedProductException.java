package com.test.io.exceptions;

public class AgeRestrictedProductException extends RuntimeException {

    public AgeRestrictedProductException(String message) {
        super(message);
    }
}
