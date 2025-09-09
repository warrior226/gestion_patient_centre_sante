package com.wendyam_rayaisse.rdvservice.repository;


import com.wendyam_rayaisse.rdvservice.entity.Rdv;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RdvRepository extends JpaRepository<Rdv,Long> {

    Optional<List<Rdv>> findByUserId(int userId);
    Optional<Rdv> findByRdvId(int rdvId);
    @Transactional
    @Modifying
    void deleteByRdvId(int rdvId);

}
