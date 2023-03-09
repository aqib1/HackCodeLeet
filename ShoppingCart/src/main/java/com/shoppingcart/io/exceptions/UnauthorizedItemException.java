package com.shoppingcart.io.exceptions;

public class UnauthorizedItemException extends RuntimeException {

    public UnauthorizedItemException(String message) {
        super(message);
    }
}
