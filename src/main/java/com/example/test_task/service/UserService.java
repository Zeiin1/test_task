package com.example.test_task.service;

import com.example.test_task.entity.User;
import com.example.test_task.entity.UserWithOldStatus;

import java.util.Optional;

public interface UserService {
    Long save(User user);

    Optional<User> findUserById(Long id);

    UserWithOldStatus changeUserStatus(Long id, String status);
}
