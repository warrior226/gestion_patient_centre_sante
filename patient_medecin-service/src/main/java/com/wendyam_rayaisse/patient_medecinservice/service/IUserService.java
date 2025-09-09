package com.wendyam_rayaisse.patient_medecinservice.service;

import com.wendyam_rayaisse.patient_medecinservice.dto.UserDto;

public interface IUserService {

    /**
     *
     * @param userDto
     */
    void createUser(UserDto userDto);

    /**
     *
     * @param patientId
     * @return
     */
    boolean deleteByPatientId(int patientId);

    /**
     *
     * @param medecinId
     * @return
     */
    boolean deleteByMedecinId(int medecinId);
}
