package com.spring.datatransferobject.service;

import java.util.List;

import com.spring.datatransferobject.dto.UserDto;
import com.spring.datatransferobject.entity.User;

public interface UserService {
    User createUser(User user);
    List<UserDto> getAllUsers();
    UserDto getUserById(Long userId);
}
