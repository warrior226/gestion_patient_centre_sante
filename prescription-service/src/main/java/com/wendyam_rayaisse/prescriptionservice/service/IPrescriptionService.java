package com.wendyam_rayaisse.prescriptionservice.service;

import com.wendyam_rayaisse.prescriptionservice.dto.PrescriptionDto;

import java.util.List;

public interface IPrescriptionService {

    /**
     *
     * @param prescriptionDto
     */
    void createPrescription(PrescriptionDto prescriptionDto);



    /**
     *
     * @param prescriptionDto
     * @return
     */
    boolean updatePrescription(PrescriptionDto prescriptionDto);

    /**
     *
     * @param consultationId
     * @return
     */
    boolean deletePrescription(int consultationId);

    /**
     *
     * @param consultationId
     * @return
     */
    List<PrescriptionDto> getAllPrescription(int consultationId);

}
