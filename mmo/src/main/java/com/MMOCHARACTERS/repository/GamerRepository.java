package com.MMOCHARACTERS.repository;

import com.MMOCHARACTERS.model.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamerRepository extends JpaRepository<Gamer, Long> {
}