package com.example.annotation.services;

import java.util.List;

import com.example.annotation.entity.Employees;

public interface EmployeeService {

    Employees createEmployee(Employees employee);
    List<Employees> findAllEmployee();
    Employees findEmployeeById(int id);
} 
