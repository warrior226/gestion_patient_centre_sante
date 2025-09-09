package com.wendyam_rayaisse.disponibiliteservice.service;

import com.wendyam_rayaisse.disponibiliteservice.dto.DisponibiliteDto;
import com.wendyam_rayaisse.disponibiliteservice.entity.Disponibilite;

import java.util.List;

public interface IDisponibiliteService {

    /**
     *
     * @param disponibiliteDto
     */
    void createDisponibilite(DisponibiliteDto disponibiliteDto);

    /**
     *
     * @param medecinId
     * @return
     */
    List<DisponibiliteDto> fetchDisponibiliteByMedecinId(int medecinId);

    /**
     *
     * @param disponibiliteDto
     * @return
     */
    boolean updateDisponibilite(DisponibiliteDto disponibiliteDto);

    /**
     *
     * @param medecinId
     * @return
     */
    boolean deleteDispobibiliteByDisponibiliteId(int medecinId);

}
