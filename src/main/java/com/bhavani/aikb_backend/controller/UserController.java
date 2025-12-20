package com.bhavani.aikb_backend.controller;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.bhavani.aikb_backend.dto.UserCreateRequest;
import com.bhavani.aikb_backend.entity.User;
import com.bhavani.aikb_backend.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody @Valid UserCreateRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        return userRepository.save(user);
    }
}
