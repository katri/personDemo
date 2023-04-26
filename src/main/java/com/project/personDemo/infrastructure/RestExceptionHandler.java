package com.project.personDemo.infrastructure;

import com.project.personDemo.infrastructure.error.ApiError;
import com.project.personDemo.infrastructure.exception.IdWrongFormatException;
import com.project.personDemo.infrastructure.exception.DateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApiError> handleIdWrongFormat(IdWrongFormatException exception) {
        ApiError apiError = new ApiError();
        apiError.setTitle(exception.getTitle());
        apiError.setStatusCode(HttpStatus.NOT_FOUND.value());
        apiError.setDetail(exception.getDetail());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handleDateException(DateException exception) {
        ApiError apiError = new ApiError();
        apiError.setTitle(exception.getTitle());
        apiError.setStatusCode(HttpStatus.FORBIDDEN.value());
        apiError.setDetail(exception.getDetail());
        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
    }
}