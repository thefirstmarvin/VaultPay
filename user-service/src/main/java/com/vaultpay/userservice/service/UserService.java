package com.vaultpay.userservice.service;

import com.vaultpay.userservice.dto.User;
import com.vaultpay.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        userRepository.save(user);
        log.info("Registering user: {} {}", user.getFirstName(), user.getLastName());
    }

    public User getUserById(String id) {
        log.info("Retrieving user with id: {}", id);
        return userRepository.findById(id).orElse(null);
    }
}