package com.wendyam_rayaisse.consultationservice.service.client;

import com.wendyam_rayaisse.consultationservice.dto.MedecinDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("medecin-service")
public interface MedecinServiceFeignClient {
    @GetMapping(value = "/api/fetchByMatricule",consumes = "application/json")
    public ResponseEntity<MedecinDto> fetchMedecinInfoDetailsByMatricule(@RequestParam String matricule);

    @GetMapping(value="/api/fetchById",consumes = "application/json")
    public ResponseEntity<MedecinDto> fetchMedecinInfoDetailsById(@RequestHeader("healthcareApp-correlation-id")String correlationId, @RequestParam int medecinId);
}
