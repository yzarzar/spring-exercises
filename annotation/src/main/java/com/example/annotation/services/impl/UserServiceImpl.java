package com.example.annotation.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.annotation.entity.Users;
import com.example.annotation.repo.UsersRepo;
import com.example.annotation.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    
    private final UsersRepo usersRepo;

    public Users createUser(Users users) {
        users.setId(users.getId());
        users.setFirstName(users.getFirstName());
        users.setLastName(users.getLastName());
        users.setEmail(users.getEmail());
        return usersRepo.save(users);
    }

    public List<Users> findAllUsers() {
        return usersRepo.findAll();
    }
}
