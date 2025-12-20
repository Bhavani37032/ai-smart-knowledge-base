package com.bhavani.aikb_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String name;
}
