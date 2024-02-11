package com.titotech.biblioteca.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_book")
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String title;
    
  /*  @Getter
    @ManyToMany
    @JoinTable(name= "tb_book_category", joinColumns = @JoinColumn(name = "book_id" ),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();*/
    
    @Getter
    @Setter
    @ManyToMany
    @JoinTable(name= "tb_book_author", joinColumns = @JoinColumn(name = "book_id" ),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();


   // public void addAuthor(Auhtor)
        


}
