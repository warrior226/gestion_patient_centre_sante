package com.wendyam_rayaisse.consultationservice.service;

import com.wendyam_rayaisse.consultationservice.dto.ConsultationDto;

import java.util.List;

public interface IConsultationService {
    /**
     *
     * @param consultationDto
     */
    void createConsultation(ConsultationDto consultationDto);

    /**
     *
     * @param userId
     * @return
     */
    List<ConsultationDto> getConsultationById(int userId);

    /**
     *
     * @param consultationDto
     */
    boolean updateConsultation(ConsultationDto consultationDto);

    /**
     *
     * @param consultationId
     * @return
     */
    boolean deleteConsultation(int consultationId);

    /**
     *
     * @param userId
     * @return
     */
    List<ConsultationDto> getAllConsultation(int userId);
}
