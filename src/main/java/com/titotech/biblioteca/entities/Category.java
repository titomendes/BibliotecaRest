package com.titotech.biblioteca.entities;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
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

    @Getter
    @JsonIgnore
    @ManyToMany(mappedBy ="categories")
    private Set<Book> books = new HashSet<>();

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
