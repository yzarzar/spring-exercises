package com.example.annotation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.annotation.entity.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{
    
}
