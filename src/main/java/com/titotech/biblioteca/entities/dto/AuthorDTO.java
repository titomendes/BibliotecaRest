package com.titotech.biblioteca.entities.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.titotech.biblioteca.entities.Author;
import com.titotech.biblioteca.entities.Book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Set<BookDTO> books = new HashSet<>();

    //construtor para mostrar livros por autor no endpoint
    public AuthorDTO(Author obj){
        for(Book x : obj.getBooks()){
            BookDTO book = new BookDTO(x);
            books.add(book);
        }
    }
}
