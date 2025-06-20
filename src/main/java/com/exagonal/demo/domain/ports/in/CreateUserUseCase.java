package com.exagonal.demo.domain.ports.in;

import com.exagonal.demo.domain.models.User;

public interface CreateUserUseCase {

    User createUser(User user);
}
