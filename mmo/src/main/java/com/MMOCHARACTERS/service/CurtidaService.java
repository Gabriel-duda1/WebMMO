package com.MMOCHARACTERS.service;

import com.MMOCHARACTERS.model.Curtida;
import com.MMOCHARACTERS.repository.CurtidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurtidaService {
    private final CurtidaRepository curtidaRepository;

    public CurtidaService(CurtidaRepository curtidaRepository) {
        this.curtidaRepository = curtidaRepository;
    }

    public Curtida salvar(Curtida curtida) {
        return curtidaRepository.save(curtida);
    }

    public List<Curtida> listarTodos() {
        return curtidaRepository.findAll();
    }

    public Optional<Curtida> buscarPorId(Long id) {
        return curtidaRepository.findById(id);
    }

    public List<Curtida> buscarPorPost(Long postId) {
        return curtidaRepository.findByPostId(postId);
    }

    public List<Curtida> buscarPorPersonagem(Long personagemId) {
        return curtidaRepository.findByPersonagemId(personagemId);
    }

    public void deletar(Long id) {
        curtidaRepository.deleteById(id);
    }
}