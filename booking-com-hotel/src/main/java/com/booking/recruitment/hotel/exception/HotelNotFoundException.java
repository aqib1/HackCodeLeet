package com.booking.recruitment.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HotelNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 5472918843681353425L;

    public HotelNotFoundException(String message) {
        super(message);
    }
}
