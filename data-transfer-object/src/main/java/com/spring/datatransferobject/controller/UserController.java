package com.spring.datatransferobject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.datatransferobject.dto.UserDto;
import com.spring.datatransferobject.entity.User;
import com.spring.datatransferobject.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User saveUser = userService.createUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> listAllUser = userService.getAllUsers();
        return new ResponseEntity<>(listAllUser, HttpStatus.OK);
    }
    
    @GetMapping("{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        UserDto getUserById = userService.getUserById(userId);
        return new ResponseEntity<>(getUserById, HttpStatus.OK);
    }
    
}
