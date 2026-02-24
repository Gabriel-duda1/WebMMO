package com.MMOCHARACTERS.repository;

import com.MMOCHARACTERS.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByPostId(Long postId);
    List<Comentario> findByPersonagemId(Long personagemId);
}