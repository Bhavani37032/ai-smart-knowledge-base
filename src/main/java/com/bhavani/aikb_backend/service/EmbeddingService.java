package com.bhavani.aikb_backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ai.embedding.EmbeddingClient;

import com.bhavani.aikb_backend.entity.*;
import com.bhavani.aikb_backend.repository.NoteEmbeddingRepository;

@Service
@RequiredArgsConstructor
public class EmbeddingService {

    private final EmbeddingClient embeddingClient;
    private final NoteEmbeddingRepository embeddingRepository;

    public void createEmbedding(Note note) {
        try {
            var vector = embeddingClient.embed(note.getContent());

            NoteEmbedding embedding =
                    new NoteEmbedding(null, note, vector.toString());

            embeddingRepository.save(embedding);

        } catch (Exception e) {
            // IMPORTANT: do not fail note creation
            System.err.println("Embedding failed: " + e.getMessage());
        }
    }
}
