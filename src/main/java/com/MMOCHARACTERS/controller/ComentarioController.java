package com.MMOCHARACTERS.controller;

import com.MMOCHARACTERS.model.Comentario;
import com.MMOCHARACTERS.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    public Comentario criarComentario(
            @RequestParam Long personagemId,
            @RequestParam Long postId,
            @RequestParam String conteudo) {

        return comentarioService.criarComentario(personagemId, postId, conteudo);
    }

    @GetMapping("/post/{postId}")
    public List<Comentario> listarPorPost(@PathVariable Long postId) {
        return comentarioService.listarPorPost(postId);
    }

    @DeleteMapping("/{id}")
    public void deletarComentario(@PathVariable Long id) {
        comentarioService.deletarComentario(id);
    }
}