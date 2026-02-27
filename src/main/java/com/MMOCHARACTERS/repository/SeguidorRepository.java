package com.MMOCHARACTERS.repository;

import com.MMOCHARACTERS.model.Seguidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SeguidorRepository extends JpaRepository<Seguidor, Long> {

    List<Seguidor> findBySeguido_Id(Long seguidoId);

    List<Seguidor> findBySeguidor_Id(Long seguidorId);

    void deleteBySeguidor_IdAndSeguido_Id(Long seguidorId, Long seguidoId);

    boolean existsBySeguidor_IdAndSeguido_Id(Long seguidorId, Long seguidoId);

    Optional<Seguidor> findBySeguidor_IdAndSeguido_Id(Long seguidorId, Long seguidoId);
}