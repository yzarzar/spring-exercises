package com.example.annotation.services;

import com.example.annotation.controllers.EmployeeController;

public interface EntityTypeService {
    EmployeeController getEntityService(String entityType);
}
