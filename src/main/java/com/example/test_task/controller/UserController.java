package com.example.test_task.controller;

import com.example.test_task.entity.User;
import com.example.test_task.entity.UserWithOldStatus;
import com.example.test_task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    // 2 task
    @PostMapping("/registration")
    public Long saveUser(@RequestParam("userName")String name,
                         @RequestParam("email")String email, @RequestParam("image_uri")String image_uri) throws Exception {
        if(name==null || email == null || image_uri == null){
            throw new Exception("You must fill all columns");
        }
        else if(name.length()<2 || email.length()<1 || image_uri.length()<2)
            throw new Exception("You must fill all columns");
        else {
            User user = new User(name, email, image_uri);
            return userService.save(user);
        }
    }
    //Проверяем все поля, если все заполнено то сохроняем пользователя
    //Если не все поля заполнены то возварщаем exception с сообщением

    // 3 task
    @GetMapping("/user/{id}")
    public Optional<User> getUserInformation(@PathVariable("id")Long id)
    {
        return userService.findUserById(id);
    }
    // чтобы найти юзера по айди

    // 4 task
    @PostMapping("/user/{id}")
    public UserWithOldStatus changeStatus(@PathVariable("id")Long id, @RequestParam("status")String status)
    {
        return userService.changeUserStatus(id,status);
    }
    // чтобы изменить статус




}
