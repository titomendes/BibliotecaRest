package com.titotech.biblioteca.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.titotech.biblioteca.services.exceptions.AuthorAlreadyExistsException;
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

    @ExceptionHandler(AuthorAlreadyExistsException.class)
    public ResponseEntity<StandardError> authorAlreadyExists(AuthorAlreadyExistsException e, HttpServletRequest  request){
        HttpStatus status = HttpStatus.FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(),status.value(),"Author already exists",e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    
}
