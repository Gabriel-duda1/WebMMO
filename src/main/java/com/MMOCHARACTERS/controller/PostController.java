package com.MMOCHARACTERS.controller;

import com.MMOCHARACTERS.model.Post;
import com.MMOCHARACTERS.repository.PostRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping
    public Post criar(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping
    public List<Post> listarFeed() {
        return postRepository.findAllByOrderByDataCriacaoDesc();
    }

    @GetMapping("/personagem/{id}")
    public List<Post> listarPorPersonagem(@PathVariable Long id) {
        return postRepository.findByPersonagemIdOrderByDataCriacaoDesc(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        postRepository.deleteById(id);
    }
}