package com.MMOCHARACTERS.service;

import com.MMOCHARACTERS.model.Gamer;
import com.MMOCHARACTERS.repository.GamerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamerService {
    private final GamerRepository gamerRepository;

    public GamerService(GamerRepository gamerRepository) {
        this.gamerRepository = gamerRepository;
    }

    public Gamer salvar(Gamer gamer) {
        return gamerRepository.save(gamer);
    }

    public List<Gamer> listarTodos() {
        return gamerRepository.findAll();
    }

    public Optional<Gamer> buscarPorId(Long id) {
        return gamerRepository.findById(id);
    }

    public void deletar(Long id) {
        gamerRepository.deleteById(id);
    }
}