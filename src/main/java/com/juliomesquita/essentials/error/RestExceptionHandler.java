package com.juliomesquita.essentials.error;

import com.juliomesquita.essentials.error.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> hendlerResourceExceptionNotFound(NotFoundException nfe) {
        ResourceDetails resourceNotFound = ResourceDetails
                .builder()
                .title("Resource Not Found")
                .status(HttpStatus.NOT_FOUND.value())
                .details(nfe.getMessage())
                .timestamp(new Date().getTime())
                .message(nfe.getClass().descriptorString())
                .build();

        return new ResponseEntity<>(resourceNotFound, HttpStatus.NOT_FOUND);
    }
}
