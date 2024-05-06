package com.juliomesquita.essentials.error;

import com.juliomesquita.essentials.error.exceptions.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> hendlerResourceExceptionNotFound(NotFoundException nfe) {
        ErrorDetails resourceNotFound = ErrorDetails
                .builder()
                .title("Resource Not Found")
                .status(HttpStatus.NOT_FOUND.value())
                .details(nfe.getMessage())
                .timestamp(new Date().getTime())
                .message(nfe.getClass().descriptorString())
                .build();

        return new ResponseEntity<>(resourceNotFound, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String fieldMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
        ValidationsErrorDetails validationsErrorDetails = ValidationsErrorDetails.ValidationBuilder
                .builder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Field Validation Error")
                .details("Field Validation Error")
                .message(ex.getClass().getName())
                .field(fields)
                .fieldMessage(fieldMessages)
                .build();
        return new ResponseEntity<>(validationsErrorDetails, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex,
            Object body,
            HttpHeaders headers,
            HttpStatusCode statusCode,
            WebRequest request
    ) {
        ErrorDetails errorDetails = ErrorDetails
                .builder()
                .title("Erro Interno.")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .details(ex.getMessage())
                .timestamp(new Date().getTime())
                .message(ex.getClass().descriptorString())
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
