package com.bhavani.aikb_backend.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.bhavani.aikb_backend.entity.*;
import com.bhavani.aikb_backend.repository.*;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public Note createNote(Long userId, String title, String content) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        note.setCreatedAt(LocalDateTime.now());
        note.setUser(user);

        return noteRepository.save(note);
    }

    public List<Note> getNotes(Long userId) {
        return noteRepository.findByUserId(userId);
    }

    public List<Note> getNotesForUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return noteRepository.findByUserId(user.getId());
    }
}
