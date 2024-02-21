package gr.majestic.reservations.controller;

import gr.majestic.reservations.exception.CustomRedisException;
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
}
