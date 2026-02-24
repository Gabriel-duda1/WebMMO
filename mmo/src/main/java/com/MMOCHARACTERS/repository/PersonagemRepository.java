package com.MMOCHARACTERS.repository;

import com.MMOCHARACTERS.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
    List<Personagem> findByJogoId(Long jogoId);
    List<Personagem> findByGamerId(Long gamerId);
}