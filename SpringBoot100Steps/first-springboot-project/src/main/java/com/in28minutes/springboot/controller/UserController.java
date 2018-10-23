package com.in28minutes.springboot.controller;

import com.in28minutes.springboot.jpa.User;
import com.in28minutes.springboot.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/page")
    public Page<User> getAll(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @GetMapping("/all")
    public Page<User> getAllSort(Pageable pageable, Boolean todos) {
        return userService.findAll(pageable, todos);
    }

}
