package com.MMOCHARACTERS.controller;

import com.MMOCHARACTERS.model.Personagem;
import com.MMOCHARACTERS.repository.PersonagemRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    private final PersonagemRepository personagemRepository;

    public PersonagemController(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    @PostMapping
    public Personagem criar(@RequestBody Personagem personagem) {
        return personagemRepository.save(personagem);
    }

    @GetMapping
    public List<Personagem> listar() {
        return personagemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Personagem buscar(@PathVariable Long id) {
        return personagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Personagem> buscarPorUsuario(@PathVariable Long usuarioId) {
        return personagemRepository.findByUsuarioId(usuarioId);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        personagemRepository.deleteById(id);
    }
}