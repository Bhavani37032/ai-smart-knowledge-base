package com.bhavani.aikb_backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.MediaType;
import java.util.Map;
import com.bhavani.aikb_backend.entity.*;
import com.bhavani.aikb_backend.repository.NoteEmbeddingRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class EmbeddingService {

    private final NoteEmbeddingRepository embeddingRepository;
    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://api.openai.com/v1")
            .defaultHeader("Authorization", "Bearer " + System.getenv("OPENAI_API_KEY"))
            .build();

    public void createEmbedding(Note note) {

        Map<String, Object> request = Map.of(
                "model", "text-embedding-3-small",
                "input", note.getContent()
        );

        Map response = webClient.post()
                .uri("/embeddings")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        List<Double> vector =
                (List<Double>) ((Map) ((List) response.get("data")).get(0)).get("embedding");

        NoteEmbedding embedding =
                new NoteEmbedding(null, note, vector.toString());

        embeddingRepository.saveAndFlush(embedding);
    }
}
