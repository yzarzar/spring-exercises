package com.spring.datatransferobject.mapper;

import com.spring.datatransferobject.dto.UserDto;
import com.spring.datatransferobject.entity.User;

public class UserMapper {
    
    public static UserDto convertEntityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
