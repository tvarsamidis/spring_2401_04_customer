package gr.majestic.reservations.controller;

import gr.majestic.reservations.exception.CustomRedisException;
import gr.majestic.reservations.exception.CustomerCreatingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomRedisException.class)
    public ResponseEntity<String> handleValidationExceptions(CustomRedisException ex) {
         return ResponseEntity.badRequest().body("Redis error: " + ex.getLocalizedMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body("Validation error: " + ex.getFieldError().getDefaultMessage());
    }
    @ExceptionHandler(CustomerCreatingException.class)
    public ResponseEntity<String> handleCustomerCreationException (CustomerCreatingException ex) {
        return ResponseEntity.badRequest().body("customerCreationError message"+ ex.getMessage());
    }
}
