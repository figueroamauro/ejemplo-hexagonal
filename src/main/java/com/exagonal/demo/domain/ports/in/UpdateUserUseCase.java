package com.exagonal.demo.domain.ports.in;

import com.exagonal.demo.domain.models.User;

public interface UpdateUserUseCase {

    User updateUser(User user);
}
