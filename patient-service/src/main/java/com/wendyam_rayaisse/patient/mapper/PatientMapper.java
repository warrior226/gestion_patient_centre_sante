package com.wendyam_rayaisse.patient.mapper;

import com.wendyam_rayaisse.patient.dto.PatientDto;
import com.wendyam_rayaisse.patient.entity.Patient;

public class PatientMapper {

    public static PatientDto mapPatientEntityToPatientDto(Patient patient,PatientDto patientDto) {
        patientDto.setMatricule(patient.getMatricule());
        patientDto.setNom(patient.getNom());
        patientDto.setPrenom(patient.getPrenom());
        patientDto.setEmail(patient.getEmail());
        patientDto.setAdresse(patient.getAdresse());
        patientDto.setContact(patient.getContact());
        patientDto.setDateNaissance(patient.getDateNaissance());
        patientDto.setGenre(patient.getGenre());
        patientDto.setProfession(patient.getProfession());
        return  patientDto;
    }

    public static Patient mapPatientDtoToPatientEntity(PatientDto patientDto,Patient patient) {
        patient.setMatricule(patientDto.getMatricule());
        patient.setNom(patientDto.getNom());
        patient.setPrenom(patientDto.getPrenom());
        patient.setEmail(patientDto.getEmail());
        patient.setAdresse(patientDto.getAdresse());
        patient.setContact(patientDto.getContact());
        patient.setDateNaissance(patientDto.getDateNaissance());
        patient.setGenre(patientDto.getGenre());
        patient.setProfession(patientDto.getProfession());
        return patient;
    }
}
