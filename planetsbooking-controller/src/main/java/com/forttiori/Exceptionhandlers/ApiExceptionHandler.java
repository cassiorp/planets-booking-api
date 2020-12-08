package com.forttiori.Exceptionhandlers;

import com.forttiori.Exceptions.PageNotFoundException;
import com.forttiori.Exceptions.PlanetNotFoundException;
import com.forttiori.Exceptions.StarshipNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ApiExceptionHandler{

    @ExceptionHandler(PlanetNotFoundException.class)
    public ResponseEntity<StandardError> planetaNotFound(PlanetNotFoundException e) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), OffsetDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(StarshipNotFoundException.class)
    public ResponseEntity<StandardError> starshipNotFound(StarshipNotFoundException e) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), OffsetDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(PageNotFoundException.class)
    public ResponseEntity<StandardError> pageNotFound(PageNotFoundException e) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), OffsetDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

}
