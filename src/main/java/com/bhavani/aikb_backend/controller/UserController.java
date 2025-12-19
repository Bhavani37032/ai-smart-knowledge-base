package com.bhavani.aikb_backend.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.bhavani.aikb_backend.entity.User;
import com.bhavani.aikb_backend.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestParam String email,
                           @RequestParam String name) {
        return userRepository.save(new User(null, email, name));
    }
}
