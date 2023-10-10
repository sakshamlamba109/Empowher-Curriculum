package com.empowher.coursemall.controller;

import com.empowher.coursemall.dto.ErrorResponseDTO;
import com.empowher.coursemall.dto.ValidationResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CourseMallExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationResponseDTO>> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        List<ValidationResponseDTO> errorMessages = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            errorMessages.add(new ValidationResponseDTO(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception ex){
        return new ResponseEntity<ErrorResponseDTO>(new ErrorResponseDTO(ex.getMessage()),HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<ErrorResponseDTO> defaultHandleException(HttpMessageConversionException ex){
        return new ResponseEntity<ErrorResponseDTO>(new ErrorResponseDTO(ex.getMessage()),HttpStatus.BAD_REQUEST);
    }
}
