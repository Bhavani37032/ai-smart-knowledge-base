package com.bhavani.aikb_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteCreateRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
