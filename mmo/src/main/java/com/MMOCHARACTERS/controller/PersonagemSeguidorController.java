package com.MMOCHARACTERS.controller;

import com.MMOCHARACTERS.model.PersonagemSeguidor;
import com.MMOCHARACTERS.service.PersonagemSeguidorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seguidores")
public class PersonagemSeguidorController {
    private final PersonagemSeguidorService personagemSeguidorService;

    public PersonagemSeguidorController(PersonagemSeguidorService personagemSeguidorService) {
        this.personagemSeguidorService = personagemSeguidorService;
    }

    @PostMapping
    public PersonagemSeguidor criar(@RequestBody PersonagemSeguidor personagemSeguidor) {
        return personagemSeguidorService.salvar(personagemSeguidor);
    }

    @GetMapping
    public List<PersonagemSeguidor> listar() {
        return personagemSeguidorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<PersonagemSeguidor> buscarPorId(@PathVariable Long id) {
        return personagemSeguidorService.buscarPorId(id);
    }

    @GetMapping("/seguidor/{seguidorId}")
    public List<PersonagemSeguidor> buscarPorSeguidor(@PathVariable Long seguidorId) {
        return personagemSeguidorService.buscarPorSeguidor(seguidorId);
    }

    @GetMapping("/seguido/{seguidoId}")
    public List<PersonagemSeguidor> buscarPorSeguido(@PathVariable Long seguidoId) {
        return personagemSeguidorService.buscarPorSeguido(seguidoId);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        personagemSeguidorService.deletar(id);
    }
}