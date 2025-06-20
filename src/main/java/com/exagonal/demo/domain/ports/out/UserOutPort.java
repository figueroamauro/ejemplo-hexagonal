package com.exagonal.demo.domain.ports.out;


import com.exagonal.demo.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface UserOutPort {

    User save(User user);

    List<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String name);

    User update(User user);

    boolean deleteById(Long id);

    User logicalDeletion(Long id);
}
