package com.MMOCHARACTERS.repository;

import com.MMOCHARACTERS.model.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CurtidaRepository extends JpaRepository<Curtida, Long> {

    boolean existsByPost_IdAndPersonagem_Id(Long postId, Long personagemId);

    void deleteByPost_IdAndPersonagem_Id(Long postId, Long personagemId);

    List<Curtida> findByPost_Id(Long postId);
}