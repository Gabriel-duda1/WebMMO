package com.MMOCHARACTERS.service;

import com.MMOCHARACTERS.model.Seguidor;
import com.MMOCHARACTERS.model.Personagem;
import com.MMOCHARACTERS.repository.SeguidorRepository;
import com.MMOCHARACTERS.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeguidorService {

    private final SeguidorRepository seguidorRepository;
    private final PersonagemRepository personagemRepository;

    public SeguidorService(SeguidorRepository seguidorRepository,
                           PersonagemRepository personagemRepository) {
        this.seguidorRepository = seguidorRepository;
        this.personagemRepository = personagemRepository;
    }

    public Seguidor seguir(Long seguidorId, Long seguidoId) {

        if (seguidorId.equals(seguidoId)) {
            throw new RuntimeException("Não pode seguir a si mesmo.");
        }

        if (seguidorRepository.existsBySeguidor_IdAndSeguido_Id(seguidorId, seguidoId)) {
            throw new RuntimeException("Já está seguindo esse personagem.");
        }

        Personagem seguidor = personagemRepository.findById(seguidorId)
                .orElseThrow(() -> new RuntimeException("Seguidor não encontrado."));

        Personagem seguido = personagemRepository.findById(seguidoId)
                .orElseThrow(() -> new RuntimeException("Seguido não encontrado."));

        Seguidor relacao = new Seguidor(seguidor, seguido);

        return seguidorRepository.save(relacao);
    }

    public void desseguir(Long seguidorId, Long seguidoId) {
        seguidorRepository.deleteBySeguidor_IdAndSeguido_Id(seguidorId, seguidoId);
    }

    public List<Seguidor> listarSeguidores(Long personagemId) {
        return seguidorRepository.findBySeguido_Id(personagemId);
    }

    public List<Seguidor> listarSeguindo(Long personagemId) {
        return seguidorRepository.findBySeguidor_Id(personagemId);
    }
}