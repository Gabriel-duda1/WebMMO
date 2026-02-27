package com.MMOCHARACTERS.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.MMOCHARACTERS.model.Personagem;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

    List<Personagem> findByNomeContainingIgnoreCase(String nome);

    List<Personagem> findByClasseIgnoreCase(String classe);

    List<Personagem> findByNivelGreaterThanEqual(Integer nivel);

    List<Personagem> findByUsuarioId(Long usuarioId);

    List<Personagem> findByJogoId(Long jogoId);
}