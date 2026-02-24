package com.MMOCHARACTERS.repository;

import com.MMOCHARACTERS.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByPersonagemId(Long personagemId);
}