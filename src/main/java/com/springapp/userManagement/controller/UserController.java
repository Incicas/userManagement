package com.springapp.userManagement.controller;


import com.springapp.userManagement.api.UserDTO;
import com.springapp.userManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){

        List<UserDTO> users = userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id){

        UserDTO user = userService.getUserById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userCreated){

        UserDTO user = userService.createUser(userCreated);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable long id, @RequestBody UserDTO newUser){

        UserDTO user = userService.updateUser(id, newUser);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable long id){

        UserDTO user = userService.deleteUser(id);

        return new ResponseEntity(user, HttpStatus.OK);
    }

}

