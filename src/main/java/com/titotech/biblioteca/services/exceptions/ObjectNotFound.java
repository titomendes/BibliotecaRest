package com.titotech.biblioteca.services.exceptions;

public class ObjectNotFound extends RuntimeException  {
    
    public ObjectNotFound(String msg){
        super(msg);
    }
}
