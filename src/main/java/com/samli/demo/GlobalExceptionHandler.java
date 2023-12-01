package com.samli.demo;

// File: src/main/java/com/samli/demo/exception/GlobalExceptionHandler.java

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

// This annotation marks this class as an advice to be applied globally to all controllers
@ControllerAdvice
public class GlobalExceptionHandler {

    // This method handles exceptions of type 'Exception' globally
    @ExceptionHandler(Exception.class)

    // This annotation sets the HTTP response status to 500 Internal Server Error
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

    // This method takes an 'Exception' object as a parameter and returns an error message
    public String handleAllExceptions(Exception ex) {
        return "An error occurred: " + ex.getMessage();
    }
}
