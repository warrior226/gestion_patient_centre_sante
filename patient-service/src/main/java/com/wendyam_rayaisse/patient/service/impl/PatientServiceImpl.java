package com.wendyam_rayaisse.patient.service.impl;


import com.wendyam_rayaisse.patient.dto.PatientDto;
import com.wendyam_rayaisse.patient.entity.Patient;
import com.wendyam_rayaisse.patient.exception.ResourceNotFoundException;
import com.wendyam_rayaisse.patient.mapper.PatientMapper;
import com.wendyam_rayaisse.patient.repository.PatientRepository;
import com.wendyam_rayaisse.patient.service.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements IPatientService {

    private PatientRepository patientRepository;

    @Override
    public void createPatient(PatientDto patientDto) {
        Patient patient = PatientMapper.mapPatientDtoToPatientEntity(patientDto,new Patient());
        System.out.println("Patient: "+patient);
        patientRepository.save(patient);
    }

    @Override
    public PatientDto getPatientByPatientId(int patientId) {
        return null;
    }

    @Override
    public PatientDto getPatientByMatricule(String matricule) {
        Patient patient=patientRepository.findPatientByMatricule(matricule).orElseThrow(
                ()->new ResourceNotFoundException("Ce matricule n'existe pas dans notre base de donnee")
        );

        return PatientMapper.mapPatientEntityToPatientDto(patient,new PatientDto());
    }

    @Override
    public boolean updatePatient(PatientDto patientDto) {
        Patient patient=patientRepository.findPatientByMatricule(patientDto.getMatricule()).orElseThrow(
                ()->new ResourceNotFoundException("Ce matricule n'existe pas dans notre base de donnee")
        );

        patient.setNom(patientDto.getNom());
        patient.setPrenom(patientDto.getPrenom());
        patient.setEmail(patientDto.getEmail());
        patient.setAdresse(patientDto.getAdresse());
        patient.setContact(patientDto.getContact());
        patient.setDateNaissance(patientDto.getDateNaissance());
        patient.setGenre(patientDto.getGenre());
        patient.setProfession(patientDto.getProfession());
        System.out.println("Patient Update: "+patient);
        patientRepository.save(patient);
        return true;
    }

    @Override
    public boolean deletePatientByMatricule(String matricule) {
        Patient patient=patientRepository.findPatientByMatricule(matricule).orElseThrow(
                ()->new ResourceNotFoundException("Ce matricule n'existe pas dans notre base de donnee")
        );
        patientRepository.deletePatientByMatricule(patient.getMatricule());
        return true;
    }
}
