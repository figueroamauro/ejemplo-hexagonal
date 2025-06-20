package com.hexagonal.demo.application.services;

import com.hexagonal.demo.application.dto.UserRequestDTO;
import com.hexagonal.demo.application.dto.UserResponseDTO;
import com.hexagonal.demo.application.mappers.UserMapper;
import com.hexagonal.demo.application.usecases.UserUseCases;
import com.hexagonal.demo.domain.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserUseCases userUseCases;

    public UserServiceImpl(UserUseCases userUseCases) {
        this.userUseCases = userUseCases;
    }


    @Override
    public UserResponseDTO save(UserRequestDTO dto) {
        User user = userUseCases.createUser(UserMapper.toModel(dto));
        return UserMapper.toResponse(user);
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return userUseCases.getUsers().stream().map(UserMapper::toResponse).toList();
    }

    @Override
    public UserResponseDTO findById(Long id) {
        User user = userUseCases.getUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return UserMapper.toResponse(user);
    }

    @Override
    public UserResponseDTO findByUsername(String name) {
        User user = userUseCases.getUserByUsername(name)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return UserMapper.toResponse(user);
    }

    @Override
    public UserResponseDTO update(UserRequestDTO dto) {
        User user = userUseCases.updateUser(UserMapper.toModel(dto));
        return UserMapper.toResponse(user);
    }

    @Override
    public UserResponseDTO deleteById(Long id) {
        User user = userUseCases.getUserById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        boolean isDeleted = userUseCases.deleteUser(id);
        if (isDeleted) {
            return UserMapper.toResponse(user);
        } else {
            throw new IllegalArgumentException("Cannot delete User =D");
        }
    }

    @Override
    public UserResponseDTO logicalDeletion(Long id) {
        User user = userUseCases.getUserById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        boolean isDeleted = userUseCases.deleteUser(id);
        if (isDeleted) {
            return UserMapper.toResponse(user);
        } else {
            throw new IllegalArgumentException("Cannot delete User =D");
        }
    }
}
