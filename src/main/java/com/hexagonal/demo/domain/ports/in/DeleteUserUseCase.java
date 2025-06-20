package com.hexagonal.demo.domain.ports.in;

import com.hexagonal.demo.domain.models.User;

public interface DeleteUserUseCase {

    boolean deleteUser(Long id);

    User logicalDeletion(Long id);
}
