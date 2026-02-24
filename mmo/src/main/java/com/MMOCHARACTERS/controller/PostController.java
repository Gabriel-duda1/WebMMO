package com.MMOCHARACTERS.controller;

import com.MMOCHARACTERS.model.Post;
import com.MMOCHARACTERS.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post criar(@RequestBody Post post) {
        return postService.salvar(post);
    }

    @GetMapping
    public List<Post> listar() {
        return postService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Post> buscarPorId(@PathVariable Long id) {
        return postService.buscarPorId(id);
    }

    @GetMapping("/personagem/{personagemId}")
    public List<Post> buscarPorPersonagem(@PathVariable Long personagemId) {
        return postService.buscarPorPersonagem(personagemId);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        postService.deletar(id);
    }
}