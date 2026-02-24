package com.MMOCHARACTERS.service;

import com.MMOCHARACTERS.model.Post;
import com.MMOCHARACTERS.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post salvar(Post post) {
        post.setDataHora(LocalDateTime.now());
        return postRepository.save(post);
    }

    public List<Post> listarTodos() {
        return postRepository.findAll();
    }

    public Optional<Post> buscarPorId(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> buscarPorPersonagem(Long personagemId) {
        return postRepository.findByPersonagemId(personagemId);
    }

    public void deletar(Long id) {
        postRepository.deleteById(id);
    }
}