package com.hexagonal.demo.domain.ports.in;

import com.hexagonal.demo.domain.models.User;

public interface CreateUserUseCase {

    User createUser(User user);
}
