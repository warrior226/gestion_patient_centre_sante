package com.wendyam_rayaisse.consultationservice.service;

import com.wendyam_rayaisse.consultationservice.dto.ConsultationDetailsDto;

public interface IConsultationDetailService
{
    /**
     *
     * @param consultationId
     * @return consultation details based on a given user id
     */
    ConsultationDetailsDto  fetchConsultationDetailsByUserId(int consultationId);
}
