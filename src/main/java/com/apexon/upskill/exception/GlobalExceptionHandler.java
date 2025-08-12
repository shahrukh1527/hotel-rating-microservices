package com.apexon.upskill.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Arrays;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidOptionException.class)
    public ResponseEntity<String> handleInvalidOptions(Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: "+ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleEnumConversionError(MethodArgumentTypeMismatchException ex) {
        if (ex.getRequiredType() != null && ex.getRequiredType().isEnum()) {
            Class<?> enumType = ex.getRequiredType();
            Object[] allowedValues = enumType.getEnumConstants();
            String message = String.format(
                    "Invalid value '%s' for parameter '%s'. Allowed values are: %s",
                    ex.getValue(),
                    ex.getName(),
                    Arrays.toString(allowedValues)
            );
            return ResponseEntity.badRequest().body(message);
        }

        return ResponseEntity.badRequest().body("Invalid parameter value.");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> defaultHandler(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: "+ex.getMessage());
    }
}
