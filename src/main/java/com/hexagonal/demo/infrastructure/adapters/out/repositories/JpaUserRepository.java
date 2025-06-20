package com.hexagonal.demo.infrastructure.adapters.out.repositories;

import com.hexagonal.demo.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsername(String name);
}
