package com.wendyam_rayaisse.rdvservice.service;

import com.wendyam_rayaisse.rdvservice.dto.RdvDto;
import com.wendyam_rayaisse.rdvservice.entity.Rdv;

import java.util.List;

public interface IRdvService {
    /**
     *
     * @param rdvDto
     */
    void createRdv(RdvDto rdvDto);

    /**
     *
     * @param rdvId
     * @return
     */
    boolean deleteByRdvId(int rdvId);

    /**
     *
     * @param userId
     * @return
     */
    List<RdvDto> findByUserId(int userId);
}
