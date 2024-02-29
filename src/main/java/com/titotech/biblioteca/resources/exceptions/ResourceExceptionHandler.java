package com.titotech.biblioteca.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.titotech.biblioteca.services.exceptions.ObjectAlreadyExistsException;
import com.titotech.biblioteca.services.exceptions.ObjectNotFound;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFound.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFound e, HttpServletRequest  request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(),status.value(),"Object was not found in the database",e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ObjectAlreadyExistsException.class)
    public ResponseEntity<StandardError> authorAlreadyExists(ObjectAlreadyExistsException e, HttpServletRequest  request){
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError err = new StandardError(System.currentTimeMillis(),status.value(),"Object already exists",e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    
}
