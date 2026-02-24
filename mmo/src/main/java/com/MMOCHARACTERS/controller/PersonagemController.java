package com.MMOCHARACTERS.controller;

import com.MMOCHARACTERS.model.Personagem;
import com.MMOCHARACTERS.service.PersonagemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {
    private final PersonagemService personagemService;

    public PersonagemController(PersonagemService personagemService) {
        this.personagemService = personagemService;
    }

    @PostMapping
    public Personagem criar(@RequestBody Personagem personagem) {
        return personagemService.salvar(personagem);
    }

    @GetMapping
    public List<Personagem> listar() {
        return personagemService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Personagem> buscarPorId(@PathVariable Long id) {
        return personagemService.buscarPorId(id);
    }

    @GetMapping("/jogo/{jogoId}")
    public List<Personagem> buscarPorJogo(@PathVariable Long jogoId) {
        return personagemService.buscarPorJogo(jogoId);
    }

    @GetMapping("/gamer/{gamerId}")
    public List<Personagem> buscarPorGamer(@PathVariable Long gamerId) {
        return personagemService.buscarPorGamer(gamerId);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        personagemService.deletar(id);
    }
}