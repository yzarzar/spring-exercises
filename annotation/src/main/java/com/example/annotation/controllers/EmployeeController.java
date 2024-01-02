package com.example.annotation.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.annotation.entity.Employees;
import com.example.annotation.entity.Users;
import com.example.annotation.services.EmployeeService;
import com.example.annotation.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final UserService userService;
    private final ObjectMapper objectMapper;

    @PostMapping("/create/{entityType}")
    public ResponseEntity<String> createEntity(@RequestBody Map<String, Object> entityMap, @PathVariable String entityType) {
        try {
            Object entity;

            if ("employee".equals(entityType)) {
                entity = objectMapper.convertValue(entityMap, Employees.class);
            } else if ("user".equals(entityType)) {
                entity = objectMapper.convertValue(entityMap, Users.class);
            } else {
                return ResponseEntity.badRequest().build();
            }

            if (entity instanceof Employees) {
                Employees savedEmployee = employeeService.createEmployee((Employees) entity);
                return new ResponseEntity<>("Employee created successfully with ID: " + savedEmployee.getId(),
                        HttpStatus.CREATED);
            } else if (entity instanceof Users) {
                Users saveUser = userService.createUser((Users) entity);
                return new ResponseEntity<>("User created successfully with ID: " + saveUser.getId(),
                        HttpStatus.CREATED);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create entity: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAll/{findEntityType}")
    public ResponseEntity<Map<String, List<?>>> findAllUsersAndEmployees(@PathVariable String findEntityType) {
        List<?> userList;

        if ("user".equals(findEntityType)) {
            userList = userService.findAllUsers();
        } else if ("employee".equals(findEntityType)) {
            userList = employeeService.findAllEmployee();
        } else {
            return ResponseEntity.badRequest().build();
        }

        Map<String, List<?>> result = new HashMap<>();
        result.put(findEntityType, userList);

        return ResponseEntity.ok(result);
    }
}
