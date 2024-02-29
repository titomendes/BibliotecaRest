package com.titotech.biblioteca.services.exceptions;

public class ObjectAlreadyExistsException extends RuntimeException {
    public ObjectAlreadyExistsException(String message) {
        super(message);
    }
}
