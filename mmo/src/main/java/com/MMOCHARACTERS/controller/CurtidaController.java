package com.MMOCHARACTERS.controller;

import com.MMOCHARACTERS.model.Curtida;
import com.MMOCHARACTERS.service.CurtidaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curtidas")
public class CurtidaController {
    private final CurtidaService curtidaService;

    public CurtidaController(CurtidaService curtidaService) {
        this.curtidaService = curtidaService;
    }

    @PostMapping
    public Curtida criar(@RequestBody Curtida curtida) {
        return curtidaService.salvar(curtida);
    }

    @GetMapping
    public List<Curtida> listar() {
        return curtidaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Curtida> buscarPorId(@PathVariable Long id) {
        return curtidaService.buscarPorId(id);
    }

    @GetMapping("/post/{postId}")
    public List<Curtida> buscarPorPost(@PathVariable Long postId) {
        return curtidaService.buscarPorPost(postId);
    }

    @GetMapping("/personagem/{personagemId}")
    public List<Curtida> buscarPorPersonagem(@PathVariable Long personagemId) {
        return curtidaService.buscarPorPersonagem(personagemId);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        curtidaService.deletar(id);
    }
}