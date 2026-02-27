package com.MMOCHARACTERS.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.MMOCHARACTERS.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByPersonagemId(Long personagemId);

    List<Post> findAllByOrderByDataCriacaoDesc();

    List<Post> findByPersonagemIdOrderByDataCriacaoDesc(Long personagemId);
}