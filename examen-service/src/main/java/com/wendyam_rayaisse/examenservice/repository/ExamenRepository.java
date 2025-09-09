package com.wendyam_rayaisse.examenservice.repository;

import com.wendyam_rayaisse.examenservice.entity.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamenRepository extends JpaRepository<Examen,Long> {

    Optional<Examen> findByConsultationId(int consultationId);

    void deleteByConsultationId(int consultationId);

    List<Examen> findByConsultationIdContaining(int consultationId);
}
