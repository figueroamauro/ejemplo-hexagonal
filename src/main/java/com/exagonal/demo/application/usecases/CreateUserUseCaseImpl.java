package com.exagonal.demo.application.usecases;

import com.exagonal.demo.domain.models.User;
import com.exagonal.demo.domain.ports.in.CreateUserUseCase;
import com.exagonal.demo.domain.ports.out.UserOutPort;
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
