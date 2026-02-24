package com.MMOCHARACTERS.controller;

import com.MMOCHARACTERS.model.Gamer;
import com.MMOCHARACTERS.service.GamerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gamers")
public class GamerController {
    private final GamerService gamerService;

    public GamerController(GamerService gamerService) {
        this.gamerService = gamerService;
    }

    @PostMapping
    public Gamer criar(@RequestBody Gamer gamer) {
        return gamerService.salvar(gamer);
    }

    @GetMapping
    public List<Gamer> listar() {
        return gamerService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Gamer> buscarPorId(@PathVariable Long id) {
        return gamerService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        gamerService.deletar(id);
    }
}