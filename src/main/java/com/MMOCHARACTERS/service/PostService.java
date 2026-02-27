package com.MMOCHARACTERS.service;

import com.MMOCHARACTERS.model.Post;
import com.MMOCHARACTERS.model.Personagem;
import com.MMOCHARACTERS.repository.PostRepository;
import com.MMOCHARACTERS.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PersonagemRepository personagemRepository;

    public PostService(PostRepository postRepository,
                       PersonagemRepository personagemRepository) {
        this.postRepository = postRepository;
        this.personagemRepository = personagemRepository;
    }

    public Post criar(Post post, Long personagemId) {

        Personagem personagem = personagemRepository.findById(personagemId)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado."));

        post.setPersonagem(personagem);
        post.setDataCriacao(LocalDateTime.now());

        return postRepository.save(post);
    }

    public List<Post> listarFeed() {
        return postRepository.findAllByOrderByDataCriacaoDesc();
    }

    public List<Post> listarPorPersonagem(Long personagemId) {
        return postRepository.findByPersonagemIdOrderByDataCriacaoDesc(personagemId);
    }

    public void deletar(Long id) {
        postRepository.deleteById(id);
    }
}