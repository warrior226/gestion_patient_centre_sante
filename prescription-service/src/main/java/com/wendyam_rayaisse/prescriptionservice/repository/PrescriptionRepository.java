package com.wendyam_rayaisse.prescriptionservice.repository;

import com.wendyam_rayaisse.prescriptionservice.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

    Optional<Prescription> findByConsultationId(int consultationId);

    void deleteByConsultationId(int consultationId);

    List<Prescription> findByConsultationIdContaining(int consultationId);

}
