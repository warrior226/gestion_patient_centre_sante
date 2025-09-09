package com.wendyam_rayaisse.examenservice.service;

import com.wendyam_rayaisse.examenservice.dto.ExamenDto;
import com.wendyam_rayaisse.examenservice.entity.Examen;

import java.util.List;

public interface IExamenService {

    /**
     *
     * @param examenDto
     */
    void createExamen(ExamenDto examenDto);

    /**
     *
     * @param examenDto
     * @return
     */
    boolean updateExamen(ExamenDto examenDto);

    /**
     *
     * @param consultationId
     * @return
     */
    boolean deleteExamen(int consultationId);

    /**
     *
     * @param consultationId
     * @return
     */
    List<ExamenDto> getAllExamen(int consultationId);

}
