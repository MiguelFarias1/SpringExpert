package com.miguel.project.program.controllers.exceptions;

import com.miguel.project.program.exceptions.EntityNotFoundException;
import com.miguel.project.program.exceptions.models.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.Instant;

@ControllerAdvice
public class HandlerException {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<StandardError> entityNotFoundHandler(EntityNotFoundException e, HttpServletRequest request) {

        StandardError error = new StandardError(Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                "Entity not found",
                e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
