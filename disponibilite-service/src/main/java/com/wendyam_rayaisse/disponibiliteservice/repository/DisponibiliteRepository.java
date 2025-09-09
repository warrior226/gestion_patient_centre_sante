package com.wendyam_rayaisse.disponibiliteservice.repository;

import com.wendyam_rayaisse.disponibiliteservice.entity.Disponibilite;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DisponibiliteRepository extends JpaRepository<Disponibilite,Long> {

    Optional<List<Disponibilite>> findByMedecinId(int medicinId);
    Optional<Disponibilite> findByDisponibiliteId(int id);

    @Transactional
    @Modifying
    void deleteByMedecinId(int medecinId);
}
