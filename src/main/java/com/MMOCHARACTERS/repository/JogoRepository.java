package com.MMOCHARACTERS.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MMOCHARACTERS.model.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

    Optional<Jogo> findByNome(String nome);

    List<Jogo> findByGenero(String genero);

    boolean existsByNome(String nome);
}