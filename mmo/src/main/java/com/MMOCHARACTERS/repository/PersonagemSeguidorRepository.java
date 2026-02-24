package com.MMOCHARACTERS.repository;

import com.MMOCHARACTERS.model.PersonagemSeguidor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonagemSeguidorRepository extends JpaRepository<PersonagemSeguidor, Long> {
    List<PersonagemSeguidor> findBySeguidorId(Long seguidorId);
    List<PersonagemSeguidor> findBySeguidoId(Long seguidoId);
}