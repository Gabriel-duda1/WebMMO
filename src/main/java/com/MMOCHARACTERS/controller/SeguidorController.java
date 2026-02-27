package com.MMOCHARACTERS.controller;

import com.MMOCHARACTERS.model.Seguidor;
import com.MMOCHARACTERS.model.Personagem;
import com.MMOCHARACTERS.repository.SeguidorRepository;
import com.MMOCHARACTERS.repository.PersonagemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seguidores")
public class SeguidorController {

    private final SeguidorRepository seguidorRepository;
    private final PersonagemRepository personagemRepository;

    public SeguidorController(SeguidorRepository seguidorRepository,
                               PersonagemRepository personagemRepository) {
        this.seguidorRepository = seguidorRepository;
        this.personagemRepository = personagemRepository;
    }

    @PostMapping("/seguir")
    public Seguidor seguir(@RequestParam Long seguidorId,
                           @RequestParam Long seguidoId) {

        if (seguidorId.equals(seguidoId)) {
            throw new RuntimeException("Personagem não pode seguir a si mesmo.");
        }

        if (seguidorRepository.existsBySeguidor_IdAndSeguido_Id(seguidorId, seguidoId)) {
            throw new RuntimeException("Já está seguindo esse personagem.");
        }

        Personagem seguidor = personagemRepository.findById(seguidorId)
                .orElseThrow(() -> new RuntimeException("Seguidor não encontrado"));

        Personagem seguido = personagemRepository.findById(seguidoId)
                .orElseThrow(() -> new RuntimeException("Seguido não encontrado"));

        Seguidor relacao = new Seguidor(seguidor, seguido);
        return seguidorRepository.save(relacao);
    }

    @DeleteMapping("/desseguir")
    public void desseguir(@RequestParam Long seguidorId,
                          @RequestParam Long seguidoId) {

        seguidorRepository.deleteBySeguidor_IdAndSeguido_Id(seguidorId, seguidoId);
    }

    @GetMapping("/{personagemId}")
    public List<Seguidor> listarSeguidores(@PathVariable Long personagemId) {
        return seguidorRepository.findBySeguido_Id(personagemId);
    }

    @GetMapping("/seguindo/{personagemId}")
    public List<Seguidor> listarSeguindo(@PathVariable Long personagemId) {
        return seguidorRepository.findBySeguidor_Id(personagemId);
    }
}