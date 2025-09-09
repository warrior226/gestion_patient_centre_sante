package com.wendyam_rayaisse.medecinservice.service;


import com.wendyam_rayaisse.medecinservice.dto.MedecinDto;

public interface IMedecinService {

    /**
     *
     * @param medecinDto
     */
    void createMedecin(MedecinDto medecinDto);

    /**
     *
     * @param patientId
     * @return
     */
    MedecinDto getMedecinById(int patientId);

    /**
     *
     * @param matricule
     * @return
     */
    MedecinDto getMedecinByMatricule(String matricule);

    /**
     *
     * @param medecinDto
     * @return
     */
    boolean updateMedecin(MedecinDto medecinDto);

    /**
     *
     * @param patientId
     * @return
     */
    boolean deleteMedecinById(int patientId);

    /**
     *
     * @param matricule
     * @return
     */
    boolean deleteMedecinByMatricule(String matricule);
}
