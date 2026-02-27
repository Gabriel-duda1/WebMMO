package com.MMOCHARACTERS.service;

import com.MMOCHARACTERS.model.Personagem;
import com.MMOCHARACTERS.model.Usuario;
import com.MMOCHARACTERS.model.Jogo;
import com.MMOCHARACTERS.repository.PersonagemRepository;
import com.MMOCHARACTERS.repository.UsuarioRepository;
import com.MMOCHARACTERS.repository.JogoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    private final PersonagemRepository personagemRepository;
    private final UsuarioRepository usuarioRepository;
    private final JogoRepository jogoRepository;

    public PersonagemService(PersonagemRepository personagemRepository,
                             UsuarioRepository usuarioRepository,
                             JogoRepository jogoRepository) {
        this.personagemRepository = personagemRepository;
        this.usuarioRepository = usuarioRepository;
        this.jogoRepository = jogoRepository;
    }

    public Personagem criar(Personagem personagem, Long usuarioId, Long jogoId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        Jogo jogo = jogoRepository.findById(jogoId)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado."));

        personagem.setUsuario(usuario);
        personagem.setJogo(jogo);

        return personagemRepository.save(personagem);
    }

    public List<Personagem> listar() {
        return personagemRepository.findAll();
    }

    public Personagem buscar(Long id) {
        return personagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado."));
    }

    public List<Personagem> buscarPorUsuario(Long usuarioId) {
        return personagemRepository.findByUsuarioId(usuarioId);
    }

    public void deletar(Long id) {
        personagemRepository.deleteById(id);
    }
}