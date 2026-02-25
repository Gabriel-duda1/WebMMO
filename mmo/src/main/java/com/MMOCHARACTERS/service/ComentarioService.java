package com.MMOCHARACTERS.service;

import com.MMOCHARACTERS.model.Comentario;
import com.MMOCHARACTERS.repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {
    private final ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public Comentario salvar(Comentario comentario) {
        comentario.setDataCriacao(LocalDateTime.now());
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> listarTodos() {
        return comentarioRepository.findAll();
    }

    public Optional<Comentario> buscarPorId(Long id) {
        return comentarioRepository.findById(id);
    }

    public List<Comentario> buscarPorPost(Long postId) {
        return comentarioRepository.findByPostId(postId);
    }

    public List<Comentario> buscarPorPersonagem(Long personagemId) {
        return comentarioRepository.findByPersonagemId(personagemId);
    }

    public void deletar(Long id) {
        comentarioRepository.deleteById(id);
    }
}