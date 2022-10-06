package com.example.test_task.service;

import com.example.test_task.entity.User;
import com.example.test_task.entity.UserWithOldStatus;
import com.example.test_task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Long save(User user) {

        userRepository.save(user);


     return userRepository.findUserByEmail(user.getEmail()).getId();// возвращаем id
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }// возвращаем юзера которого нашли по id

    @Override
    public UserWithOldStatus changeUserStatus(Long id, String status) {
        User user = userRepository.findUserById(id);
        String oldStatus = user.getStatus();
        user.setStatus(status);
        userRepository.save(user);
        UserWithOldStatus userWithOldStatus = new UserWithOldStatus(user.getId(),status,oldStatus);
        return userWithOldStatus;
        //чтобы изменить статус пользователя и вернуть пользователю id, status и старый статус



    }
}
