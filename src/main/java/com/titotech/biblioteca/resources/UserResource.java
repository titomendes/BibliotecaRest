package com.titotech.biblioteca.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.titotech.biblioteca.entities.User;
import com.titotech.biblioteca.entities.dto.UserDTO;
import com.titotech.biblioteca.services.UserService;


@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService service;
    
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAlll(){
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect((Collectors.toList()));
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id ){
       User obj = service.findById(id);
       return ResponseEntity.ok().body(new UserDTO(obj));   
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody UserDTO obj){
      UserDTO dto = new UserDTO();
      User user = dto .fromDTO(obj);
      user = service.insert(user);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
      return ResponseEntity.created(uri).body(user);
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UserDTO obj) {
      UserDTO dto = new UserDTO();
      User user = dto .fromDTO(obj);
      user = service.update(id, user);
        return ResponseEntity.ok().body(user);
    }
}
