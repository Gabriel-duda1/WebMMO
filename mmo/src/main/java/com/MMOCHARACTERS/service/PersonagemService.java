package com.MMOCHARACTERS.service;

import com.MMOCHARACTERS.model.Personagem;
import com.MMOCHARACTERS.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {
    private final PersonagemRepository personagemRepository;

    public PersonagemService(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    public Personagem salvar(Personagem personagem) {
        return personagemRepository.save(personagem);
    }

    public List<Personagem> listarTodos() {
        return personagemRepository.findAll();
    }

    public Optional<Personagem> buscarPorId(Long id) {
        return personagemRepository.findById(id);
    }

    public List<Personagem> buscarPorJogo(Long jogoId) {
        return personagemRepository.findByJogoId(jogoId);
    }

    public List<Personagem> buscarPorGamer(Long gamerId) {
        return personagemRepository.findByGamerId(gamerId);
    }

    public void deletar(Long id) {
        personagemRepository.deleteById(id);
    }
}