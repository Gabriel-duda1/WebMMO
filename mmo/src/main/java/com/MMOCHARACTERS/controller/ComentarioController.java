package com.MMOCHARACTERS.controller;

import com.MMOCHARACTERS.model.Comentario;
import com.MMOCHARACTERS.service.ComentarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    public Comentario criar(@RequestBody Comentario comentario) {
        return comentarioService.salvar(comentario);
    }

    @GetMapping
    public List<Comentario> listar() {
        return comentarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Comentario> buscarPorId(@PathVariable Long id) {
        return comentarioService.buscarPorId(id);
    }

    @GetMapping("/post/{postId}")
    public List<Comentario> buscarPorPost(@PathVariable Long postId) {
        return comentarioService.buscarPorPost(postId);
    }

    @GetMapping("/personagem/{personagemId}")
    public List<Comentario> buscarPorPersonagem(@PathVariable Long personagemId) {
        return comentarioService.buscarPorPersonagem(personagemId);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        comentarioService.deletar(id);
    }
}