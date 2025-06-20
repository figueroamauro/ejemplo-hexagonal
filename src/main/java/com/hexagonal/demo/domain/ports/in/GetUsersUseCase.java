package com.hexagonal.demo.domain.ports.in;

import com.hexagonal.demo.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface GetUsersUseCase {

    List<User> getUsers();

    Optional<User> getUserById(Long id);

    Optional<User> getUserByUsername(String username);
}
