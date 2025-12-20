package com.bhavani.aikb_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bhavani.aikb_backend.entity.NoteEmbedding;

public interface NoteEmbeddingRepository
        extends JpaRepository<NoteEmbedding, Long> {
}
