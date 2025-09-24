package com.wendyam_rayaisse.consultationservice.service.client;

import com.wendyam_rayaisse.consultationservice.dto.MedecinDto;
import com.wendyam_rayaisse.consultationservice.dto.PatientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PatientServiceFallback implements PatientServiceFeignClient {

    @Override
    public ResponseEntity<PatientDto> fetchPatientInfoDetails(String matricule) {
        return null;
    }

    @Override
    public ResponseEntity<PatientDto> fetchPatientInfoDetailsById(String correlationId, int patientId) {
        return null;
    }
}
