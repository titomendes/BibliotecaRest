package com.titotech.biblioteca.services.exceptions;

public class AuthorAlreadyExistsException extends RuntimeException {
    public AuthorAlreadyExistsException(String message) {
        super(message);
    }
}
