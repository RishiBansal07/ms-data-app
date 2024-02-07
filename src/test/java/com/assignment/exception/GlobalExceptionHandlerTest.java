package com.assignment.exception;

import com.assignment.exceptions.GlobalExceptionHandler;
import com.assignment.exceptions.NotFoundException;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.ErrorResponse;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
public class GlobalExceptionHandlerTest {

    @InjectMocks
    GlobalExceptionHandler globalExceptionHandler;

    @Test
    void shouldHandleNotFoundException() {
        NotFoundException exception = new NotFoundException("not found");
        ResponseEntity<GlobalExceptionHandler.ErrorResponse> errorResponse = globalExceptionHandler.notFoundException(exception);
        GlobalExceptionHandler.ErrorResponse responseBody = errorResponse.getBody();
        assertNotNull(responseBody);
        assertThat(responseBody.errorCode()).isEqualTo("400");
        assertThat(responseBody.errorMessage()).isEqualTo("not found");
    }
}
