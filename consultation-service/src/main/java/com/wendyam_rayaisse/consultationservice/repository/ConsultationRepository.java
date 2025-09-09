package com.wendyam_rayaisse.consultationservice.repository;


import com.wendyam_rayaisse.consultationservice.dto.ConsultationDto;
import com.wendyam_rayaisse.consultationservice.entity.Consultation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
    Optional<List<Consultation>> findByUserId(int userId);

    Optional<Consultation> findByConsultationId(int consultationId);

    @Transactional
    @Modifying
    void deleteByConsultationId(int userId);


}
