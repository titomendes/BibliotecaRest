package com.titotech.biblioteca.entities.dto;

import java.io.Serializable;

import com.titotech.biblioteca.entities.Book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;

    public BookDTO(Book obj){
        this.title=obj.getTitle();
    }
}


