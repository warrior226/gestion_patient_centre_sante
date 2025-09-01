package com.wendyam_rayaisse.patient.service;


import com.wendyam_rayaisse.patient.dto.PatientDto;

import java.util.UUID;

public interface IPatientService {

    /**
     *
     * @param patientDto
     */
    void createPatient(PatientDto patientDto);

    /**
     *
     * @param patientId
     * @return
     */
    PatientDto getPatientByPatientId(int patientId);

    /**
     *
     * @param matricule
     * @return
     */
    PatientDto getPatientByMatricule(String matricule);


    /**
     *
     * @param patientDto
     */
    boolean updatePatient(PatientDto patientDto);

    /**
     *
     * @param matricule
     * @return
     */
    boolean deletePatientByMatricule(String matricule);


}
