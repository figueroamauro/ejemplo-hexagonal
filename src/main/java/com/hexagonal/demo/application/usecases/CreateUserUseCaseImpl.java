package com.hexagonal.demo.application.usecases;

import com.hexagonal.demo.domain.models.User;
import com.hexagonal.demo.domain.ports.in.CreateUserUseCase;
import com.hexagonal.demo.domain.ports.out.UserOutPort;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserOutPort userRepositoryOutPort;

    public CreateUserUseCaseImpl(UserOutPort userRepositoryOutPort) {
        this.userRepositoryOutPort = userRepositoryOutPort;
    }


    @Override
    public User createUser(User user) {
        return userRepositoryOutPort.save(user);
    }
}
