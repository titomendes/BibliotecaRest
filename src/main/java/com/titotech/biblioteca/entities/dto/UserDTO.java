package com.titotech.biblioteca.entities.dto;

import java.io.Serializable;

import com.titotech.biblioteca.entities.User;

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

    public User fromDTO(UserDTO obj){
        User user = new User(obj.getId(), obj.getUserName(), obj.getEmail());
        return user;
    }
}
