package com.booking.recruitment.hotel.controller.advice;

import com.booking.recruitment.hotel.dto.ResponseError;
import com.booking.recruitment.hotel.exception.HotelNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Optional;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value
            = HotelNotFoundException.class)
    public ResponseEntity<ResponseError> handleHotelNotFoundException(
            HotelNotFoundException e) {
        String error = Optional.ofNullable(e.getMessage()).orElse(e.getClass().getName())
                + " [Internal server exception! => (HotelNotFoundException)]";
        ResponseError errorResponse = ResponseError.builder()
                .createdAt(LocalDateTime.now().toString())
                .detailedMessage(error)
                .errorCode(HttpStatus.NOT_FOUND.value())
                .exceptionName(HotelNotFoundException.class.getName())
                .errorMessage(e.getMessage()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
