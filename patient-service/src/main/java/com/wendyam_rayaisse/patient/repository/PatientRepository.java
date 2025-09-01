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

    Optional<Patient> findPatientByPatientId(int patientId);

    Optional<Patient> findPatientByMatricule(String matricule);

    @Transactional
    @Modifying
    void deletePatientByPatientId(int patientId);

    @Transactional
    @Modifying
    void deletePatientByMatricule(String matricule);
}
