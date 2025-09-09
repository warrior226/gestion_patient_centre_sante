package com.wendyam_rayaisse.patient.repository;


import com.wendyam_rayaisse.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByPatientId(int patientId);

    Optional<Patient> findByMatricule(String matricule);

    @Transactional
    @Modifying
    void deleteByPatientId(int patientId);

    @Transactional
    @Modifying
    void deleteByMatricule(String matricule);
}
