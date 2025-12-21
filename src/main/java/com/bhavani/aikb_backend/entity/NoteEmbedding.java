package com.bhavani.aikb_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "note_embedding")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteEmbedding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "note_id", nullable = false)
    private Note note;

    @Lob
    @Column(nullable = false)
    private String vector;
}
