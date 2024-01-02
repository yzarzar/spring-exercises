package com.example.annotation.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.annotation.entity.Employees;
import com.example.annotation.repo.EmployeeRepo;
import com.example.annotation.services.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    
    private final EmployeeRepo employeeRepo;

    public Employees createEmployee(Employees employee) {
        employee.setId(employee.getId());
        employee.setFirstName(employee.getFirstName());
        employee.setEmail(employee.getEmail());
        return employeeRepo.save(employee);
    }

    public List<Employees> findAllEmployee() {
        return employeeRepo.findAll();
    }

    public Employees findEmployeeById(int id) {
        return employeeRepo.findById(id).orElse(null);
    }

}
