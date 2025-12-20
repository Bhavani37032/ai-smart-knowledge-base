package com.bhavani.aikb_backend.controller;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import com.bhavani.aikb_backend.dto.NoteCreateRequest;
import com.bhavani.aikb_backend.entity.Note;
import com.bhavani.aikb_backend.service.NoteService;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public Note createNote(@RequestBody @Valid NoteCreateRequest request) {
        return noteService.createNote(
                request.getUserId(),
                request.getTitle(),
                request.getContent()
        );
    }

    @GetMapping
    public List<Note> getNotes(HttpServletRequest request) {
        String email = (String) request.getAttribute("email");
        return noteService.getNotesForUser(email);
    }
}
