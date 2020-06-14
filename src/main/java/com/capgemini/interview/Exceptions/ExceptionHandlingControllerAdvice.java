package com.capgemini.interview.Exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class ExceptionHandlingControllerAdvice {

    @ExceptionHandler(NotUniqueException.class)
    public ResponseEntity<String> handleNotUniqueException(NotUniqueException ex) {
        return response("Item Not Unique", ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return response("Item Not Found", ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    private static String createJson(String message, String reason) {
        return "{\"error\" : \"" + message + "\"," + "\"reason\" : \"" + reason + "\"}";
    }

    private static ResponseEntity<String> response(String message, String reason, HttpStatus httpStatus) {
        String json = createJson(message, reason);
        return new ResponseEntity<>(json, httpStatus);
    }
}