package com.exagonal.demo.domain.ports.in;

import com.exagonal.demo.domain.models.User;

public interface DeleteUserUseCase {

    boolean deleteUser(Long id);

    User logicalDeletion(Long id);
}
