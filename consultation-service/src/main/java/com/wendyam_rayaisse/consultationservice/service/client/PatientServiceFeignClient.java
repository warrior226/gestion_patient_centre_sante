package com.wendyam_rayaisse.consultationservice.service.client;


import com.wendyam_rayaisse.consultationservice.dto.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="patient-service",fallback = PatientServiceFallback.class)
public interface PatientServiceFeignClient {
    @GetMapping(value="/api/fetch",consumes = "application/json")
    public ResponseEntity<PatientDto> fetchPatientInfoDetails(@RequestParam String matricule);

    @GetMapping(value = "/api/fetchById",consumes = "application/json")
    public ResponseEntity<PatientDto> fetchPatientInfoDetailsById(@RequestHeader("healthcareApp-correlation-id")String correlationId, @RequestParam int patientId);
}
