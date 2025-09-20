package com.wendyam_rayaisse.medecinservice.repository;


import com.wendyam_rayaisse.medecinservice.entity.Medecin;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Optional<Medecin> findByMedecinId(int medecinId);

    Optional<Medecin> findByMatricule(String matricule);


    @Transactional
    @Modifying
    void deleteByMedecinId(int medecinId);

    @Transactional
    @Modifying
    void deleteByMatricule(String matricule);

}
