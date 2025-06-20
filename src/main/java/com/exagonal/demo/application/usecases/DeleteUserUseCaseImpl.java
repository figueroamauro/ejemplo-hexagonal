package com.exagonal.demo.application.usecases;

import com.exagonal.demo.domain.models.User;
import com.exagonal.demo.domain.ports.in.DeleteUserUseCase;
import com.exagonal.demo.domain.ports.out.UserOutPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {
    private final UserOutPort userRepositoryOutPort;

    public DeleteUserUseCaseImpl(UserOutPort userRepositoryOutPort) {
        this.userRepositoryOutPort = userRepositoryOutPort;
    }

    @Override
    public boolean deleteUser(Long id) {
        return userRepositoryOutPort.deleteById(id);
    }

    @Override
    public User logicalDeletion(Long id) {
        return userRepositoryOutPort.logicalDeletion(id);
    }
}
