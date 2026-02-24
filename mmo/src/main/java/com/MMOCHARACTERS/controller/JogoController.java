package com.MMOCHARACTERS.controller;

import com.MMOCHARACTERS.model.Jogo;
import com.MMOCHARACTERS.service.JogoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogos")
public class JogoController {
    private final JogoService jogoService;

    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @PostMapping
    public Jogo criar(@RequestBody Jogo jogo) {
        return jogoService.salvar(jogo);
    }

    @GetMapping
    public List<Jogo> listar() {
        return jogoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Jogo> buscarPorId(@PathVariable Long id) {
        return jogoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        jogoService.deletar(id);
    }
}