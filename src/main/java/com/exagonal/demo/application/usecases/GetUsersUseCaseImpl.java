package com.exagonal.demo.application.usecases;

import com.exagonal.demo.domain.models.User;
import com.exagonal.demo.domain.ports.in.GetUsersUseCase;
import com.exagonal.demo.domain.ports.out.UserOutPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetUsersUseCaseImpl implements GetUsersUseCase {
    private final UserOutPort userRepositoryOutPort;

    public GetUsersUseCaseImpl(UserOutPort userRepositoryOutPort) {
        this.userRepositoryOutPort = userRepositoryOutPort;
    }


    @Override
    public List<User> getUsers() {
        return userRepositoryOutPort.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepositoryOutPort.findById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepositoryOutPort.findByUsername(username);
    }


}
