package com.exagonal.demo.application.services;

import com.exagonal.demo.application.dto.UserRequestDTO;
import com.exagonal.demo.application.dto.UserResponseDTO;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface UserService {

    UserResponseDTO save(UserRequestDTO dto);

    List<UserResponseDTO> findAll();

    UserResponseDTO findById(Long id);

    UserResponseDTO findByUsername(String name);

    UserResponseDTO update(UserRequestDTO dto);

    UserResponseDTO deleteById(Long id);

    UserResponseDTO logicalDeletion(Long id);
}
