package com.MMOCHARACTERS.service;

import com.MMOCHARACTERS.model.Jogo;
import com.MMOCHARACTERS.repository.JogoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    private final JogoRepository jogoRepository;

    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public Jogo criar(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    public List<Jogo> listar() {
        return jogoRepository.findAll();
    }

    public Jogo buscar(Long id) {
        return jogoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado."));
    }

    public void deletar(Long id) {
        jogoRepository.deleteById(id);
    }
}