package com.example.annotation.services;

import java.util.List;

import com.example.annotation.entity.Users;

public interface UserService {
    
    Users createUser(Users users);
    List<Users> findAllUsers();
}
