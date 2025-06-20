package com.exagonal.demo.infrastructure.adapters.out.repositories;

import com.exagonal.demo.domain.models.User;
import com.exagonal.demo.domain.ports.out.UserOutPort;
import com.exagonal.demo.infrastructure.entities.UserEntity;
import com.exagonal.demo.infrastructure.mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAdapter implements UserOutPort {
    private final JpaUserRepository userRepository;

    public UserAdapter(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        UserEntity savedEntity = userRepository.save(entity);
        return UserMapper.toModel(savedEntity);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream().map(UserMapper::toModel).toList();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id).map(UserMapper::toModel);
    }

    @Override
    public Optional<User> findByUsername(String name) {
        return userRepository.findByUsername(name).map(UserMapper::toModel);
    }

    @Override
    public User update(User user) {
        UserEntity entity = userRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        entity.setEmail(user.getEmail());
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());

        UserEntity savedEntity = userRepository.save(entity);

        return UserMapper.toModel(savedEntity);
    }

    @Override
    public boolean deleteById(Long id) {
        boolean exist = userRepository.existsById(id);
        if (exist) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User logicalDeletion(Long id) {
        return null;
    }
}
