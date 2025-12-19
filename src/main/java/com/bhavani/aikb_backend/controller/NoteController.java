package com.bhavani.aikb_backend.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.bhavani.aikb_backend.entity.Note;
import com.bhavani.aikb_backend.service.NoteService;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public Note createNote(
            @RequestParam Long userId,
            @RequestParam String title,
            @RequestParam String content) {
        return noteService.createNote(userId, title, content);
    }

    @GetMapping
    public List<Note> getNotes(@RequestParam Long userId) {
        return noteService.getNotes(userId);
    }
}
