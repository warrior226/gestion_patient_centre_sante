package com.wendyam_rayaisse.constanteservice.repository;

import com.wendyam_rayaisse.constanteservice.entity.Constantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface ConstanteRepository extends JpaRepository<Constantes,Long>{


    Optional<Constantes> findByPatientId(int patientId);

    @Transactional
    @Modifying
    void deleteByPatientId(int patientId);
}
