package com.titotech.biblioteca.entities;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String userName;
    private String email;

    public UserDTO(User obj){
        this.id=obj.getId();
        this.userName=obj.getUserName();
        this.email=obj.getEmail();
    }
}
