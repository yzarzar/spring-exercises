package com.example.annotation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.annotation.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
    
}
