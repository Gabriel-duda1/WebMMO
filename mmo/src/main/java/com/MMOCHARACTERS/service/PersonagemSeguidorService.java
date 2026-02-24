package com.MMOCHARACTERS.service;

import com.MMOCHARACTERS.model.PersonagemSeguidor;
import com.MMOCHARACTERS.repository.PersonagemSeguidorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemSeguidorService {
    private final PersonagemSeguidorRepository personagemSeguidorRepository;

    public PersonagemSeguidorService(PersonagemSeguidorRepository personagemSeguidorRepository) {
        this.personagemSeguidorRepository = personagemSeguidorRepository;
    }

    public PersonagemSeguidor salvar(PersonagemSeguidor personagemSeguidor) {
        return personagemSeguidorRepository.save(personagemSeguidor);
    }

    public List<PersonagemSeguidor> listarTodos() {
        return personagemSeguidorRepository.findAll();
    }

    public Optional<PersonagemSeguidor> buscarPorId(Long id) {
        return personagemSeguidorRepository.findById(id);
    }

    public List<PersonagemSeguidor> buscarPorSeguidor(Long seguidorId) {
        return personagemSeguidorRepository.findBySeguidorId(seguidorId);
    }

    public List<PersonagemSeguidor> buscarPorSeguido(Long seguidoId) {
        return personagemSeguidorRepository.findBySeguidoId(seguidoId);
    }

    public void deletar(Long id) {
        personagemSeguidorRepository.deleteById(id);
    }
}