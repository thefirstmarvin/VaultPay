package com.vaultpay.userservice.controller;

import com.vaultpay.userservice.dto.User;
import com.vaultpay.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserServiceController {

    private final UserService userService;

    public UserServiceController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void registerUser(@Valid @RequestBody User user) {
        userService.registerUser(user);
        log.info("User registered successfully");
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable String id) {
        log.info("Fetched user with id: {}", id);
        return userService.getUserById(id);
    }
}