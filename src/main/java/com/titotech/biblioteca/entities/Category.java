package com.titotech.biblioteca.entities;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name="tb_category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String name;
    
  /*  @Getter
    @ManyToMany(mappedBy ="categories")
    private Set<Book> books = new HashSet<>();*/

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
