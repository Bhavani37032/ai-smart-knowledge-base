package com.bhavani.aikb_backend.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.bhavani.aikb_backend.entity.*;
import com.bhavani.aikb_backend.repository.*;
import com.bhavani.aikb_backend.dto.NoteCreateRequest;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final EmbeddingService embeddingService;

    public Note createNote(String email, NoteCreateRequest request) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setUser(user);
        note.setCreatedAt(LocalDateTime.now());

        Note saved = noteRepository.save(note);

        embeddingService.createEmbedding(saved);

        return saved;
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
