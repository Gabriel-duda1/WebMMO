package com.MMOCHARACTERS.controller;

import com.MMOCHARACTERS.model.Jogo;
import com.MMOCHARACTERS.repository.JogoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    private final JogoRepository jogoRepository;

    public JogoController(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    @PostMapping
    public Jogo criar(@RequestBody Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    @GetMapping
    public List<Jogo> listar() {
        return jogoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Jogo buscar(@PathVariable Long id) {
        return jogoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        jogoRepository.deleteById(id);
    }
}