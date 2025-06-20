package com.hexagonal.demo.infrastructure.mappers;

import com.hexagonal.demo.domain.models.User;
import com.hexagonal.demo.infrastructure.entities.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        return new UserEntity(user.getId(), user.getUsername(), user.getEmail(), user.getPassword());
    }

    public static User toModel(UserEntity entity) {
        return new User(entity.getId(), entity.getUsername(), entity.getEmail(), entity.getPassword());
    }
}
