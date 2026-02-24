package com.MMOCHARACTERS.repository;

import com.MMOCHARACTERS.model.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurtidaRepository extends JpaRepository<Curtida, Long> {
    List<Curtida> findByPostId(Long postId);
    List<Curtida> findByPersonagemId(Long personagemId);
}