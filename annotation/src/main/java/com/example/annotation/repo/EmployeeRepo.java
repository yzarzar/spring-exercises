package com.example.annotation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.annotation.entity.Employees;

public interface EmployeeRepo extends JpaRepository<Employees, Integer>{
    
}
