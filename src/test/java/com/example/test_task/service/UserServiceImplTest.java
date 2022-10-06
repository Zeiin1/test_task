package com.example.test_task.service;

import com.example.test_task.entity.User;
import com.example.test_task.entity.UserWithOldStatus;
import com.example.test_task.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    public void checkMethod()
    {
        UserWithOldStatus userWithOldStatus = userService.changeUserStatus(1L,"offline");
        System.out.println(userWithOldStatus.getId());


    }


}