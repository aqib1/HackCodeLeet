package com.dresslif.main.exceptions;

public class ErrorResponseException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 2809306975311109014L;



    public ErrorResponseException(String message, Throwable e) {
        super(message, e);
    }

    public ErrorResponseException(String message) {
        this(message, null);
    }

}