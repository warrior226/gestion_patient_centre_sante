package com.wendyam_rayaisse.patient_medecinservice.repository;

import com.wendyam_rayaisse.patient_medecinservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    /**
     *
     * @param patientId
     * @param medecinId
     * @return
     */
    boolean existsByPatientIdAndMedecinId(int patientId,int medecinId);

    /**
     *
     * @param patient
     * @return
     */
    boolean deleteByPatientId(int patient);

    /**
     *
     * @param medecinId
     * @return
     */
    boolean deleteByMedecinId(int medecinId);
}
