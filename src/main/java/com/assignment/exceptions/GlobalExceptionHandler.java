package com.assignment.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({Throwable.class})
    public ResponseEntity<ErrorResponse> handleException(Throwable ex) {
        if (log.isErrorEnabled()) {
            log.error("Unknown exception: " + ex.getMessage(), ex);
        }
        ErrorResponse errorResponse = new ErrorResponse("500", ex.getMessage(), Instant.now().toString());
        return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorResponse> notFoundException(NotFoundException ex) {
        if (log.isErrorEnabled()) {
            log.error("Not found Exception: " + ex.getMessage(), ex);
        }
        ErrorResponse errorResponse = new ErrorResponse("400", ex.getMessage(), Instant.now().toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(DataIntegrityViolationException ex) {
        if (log.isErrorEnabled()) {
            log.error("Constraint Validation Exception: " + ex.getMessage(), ex);
        }
        return new ResponseEntity<>(new ErrorResponse("400", ex.getMessage(), Instant.now().toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        if (log.isErrorEnabled()) {
            log.error("Constraint Validation Exception: " + ex.getMessage(), ex);
        }
        String message = ex.getConstraintViolations().stream().filter(Objects::nonNull).map(ConstraintViolation::getMessage).collect(Collectors.joining(", "));
        return new ResponseEntity<>(new ErrorResponse("400", ex.getMessage(), Instant.now().toString()), HttpStatus.BAD_REQUEST);
    }

    public record ErrorResponse(String errorCode, String errorMessage, String timestamp) {

    }
}
