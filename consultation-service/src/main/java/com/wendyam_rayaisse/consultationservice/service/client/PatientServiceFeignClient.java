package com.wendyam_rayaisse.consultationservice.service.client;


import com.wendyam_rayaisse.consultationservice.dto.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("patient-service")
public interface PatientServiceFeignClient {
    @GetMapping(value="/api/fetch",consumes = "application/json")
    public ResponseEntity<PatientDto> fetchPatientInfoDetails(@RequestParam String matricule);

    @GetMapping(value = "/fetchById",consumes = "application/json")
    public ResponseEntity<PatientDto> fetchPatientInfoDetailsById(@RequestParam int patientId);
}
