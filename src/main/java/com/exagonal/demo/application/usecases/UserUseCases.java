package com.exagonal.demo.application.usecases;

import com.exagonal.demo.domain.models.User;
import com.exagonal.demo.domain.ports.in.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserUseCases implements UserInPort {
    private final CreateUserUseCase createUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final GetUsersUseCase getUsersUseCase;

    public UserUseCases(CreateUserUseCase createUserUseCase, DeleteUserUseCase deleteUserUseCase, UpdateUserUseCase updateUserUseCase, GetUsersUseCase getUsersUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.getUsersUseCase = getUsersUseCase;
    }


    @Override
    public User createUser(User user) {
        return createUserUseCase.createUser(user);
    }

    @Override
    public boolean deleteUser(Long id) {
        return deleteUserUseCase.deleteUser(id);
    }

    @Override
    public User logicalDeletion(Long id) {
        return deleteUserUseCase.logicalDeletion(id);
    }

    @Override
    public List<User> getUsers() {
        return getUsersUseCase.getUsers();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return getUsersUseCase.getUserById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return getUsersUseCase.getUserByUsername(username);
    }

    @Override
    public User updateUser(User user) {
        return updateUserUseCase.updateUser(user);
    }
}
