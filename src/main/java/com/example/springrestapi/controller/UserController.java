package com.example.springrestapi.controller;

import com.example.springrestapi.modal.User;
import com.example.springrestapi.services.NoRecordFoundException;
import com.example.springrestapi.services.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userDaoService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Integer id){
        User user =  userDaoService.findUser(id);
        if(user==null){
             throw new NoRecordFoundException("id-"+id);
        }
        return user;
    }
    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user){
        User savedUser =  userDaoService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return  ResponseEntity.created(location).build();

    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id){
        User deletedUser =  userDaoService.deleteUserById(id);
        if(deletedUser==null){
            throw new NoRecordFoundException("id-"+id);
        }
       // return deletedUser;

    }
}
