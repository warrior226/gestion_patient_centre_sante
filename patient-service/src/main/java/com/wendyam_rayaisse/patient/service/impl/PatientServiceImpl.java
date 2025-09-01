package com.wendyam_rayaisse.patient.service.impl;


import com.wendyam_rayaisse.patient.constants.PatientConstants;
import com.wendyam_rayaisse.patient.dto.PatientDto;
import com.wendyam_rayaisse.patient.entity.Patient;
import com.wendyam_rayaisse.patient.mapper.PatientMapper;
import com.wendyam_rayaisse.patient.repository.PatientRepository;
import com.wendyam_rayaisse.patient.service.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements IPatientService {

    private PatientRepository patientRepository;

    @Override
    public void createPatient(PatientDto patientDto) {
        Patient patient = PatientMapper.mapPatientDtoToPatientEntity(patientDto,new Patient());
        //generateMatricule
        var matricule=PatientConstants.generateMatricule(patientDto.getNom(),patientDto.getPrenom());
        patient.setMatricule(matricule);
        System.out.println("Patient: "+patient);
        //Optional<Patient> patientOptional = patientRepository.findPatientByMatricule(patient.getMatricule());
    }

    @Override
    public PatientDto getPatientByPatientId(UUID patientId) {
        return null;
    }

    @Override
    public PatientDto getPatientByMatricule(String matricule) {
        return null;
    }

    @Override
    public void updatePatient(PatientDto patientDto) {

    }

    @Override
    public boolean deletePatientByPatientId(UUID patientId) {
        return false;
    }
}
