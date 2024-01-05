package com.spring.datatransferobject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.datatransferobject.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
