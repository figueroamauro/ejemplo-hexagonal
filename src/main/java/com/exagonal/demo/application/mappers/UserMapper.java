package com.exagonal.demo.application.mappers;

import com.exagonal.demo.application.dto.UserRequestDTO;
import com.exagonal.demo.application.dto.UserResponseDTO;
import com.exagonal.demo.domain.models.User;

public class UserMapper {

    public static User toModel(UserRequestDTO requestDTO) {
        return new User(requestDTO.getId(),requestDTO.getUsername(), requestDTO.getEmail(), requestDTO.getPassword());
    }

    public static UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(user.getId(), user.getUsername(), user.getEmail());
    }
}
