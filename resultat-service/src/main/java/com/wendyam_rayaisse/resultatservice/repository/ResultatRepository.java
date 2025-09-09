package com.wendyam_rayaisse.resultatservice.repository;


import com.wendyam_rayaisse.resultatservice.entity.Resultat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultatRepository extends JpaRepository<Resultat,Long> {
    Optional<List<Resultat>> findByExamenIdContaining(int examenId);
    boolean deleteByExamenId(int examenId);
    Optional<Resultat> findByExamenId(int examentId);

}
