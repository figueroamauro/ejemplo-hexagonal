package com.exagonal.demo.application.usecases;

import com.exagonal.demo.domain.models.User;
import com.exagonal.demo.domain.ports.in.UpdateUserUseCase;
import com.exagonal.demo.domain.ports.out.UserOutPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {
    private final UserOutPort userRepositoryOutPort;

    public UpdateUserUseCaseImpl(UserOutPort userRepositoryOutPort) {
        this.userRepositoryOutPort = userRepositoryOutPort;
    }

    @Override
    public User updateUser(User user) {
        return userRepositoryOutPort.update(user);
    }
}
