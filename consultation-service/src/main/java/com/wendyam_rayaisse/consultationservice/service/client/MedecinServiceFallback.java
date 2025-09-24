package com.wendyam_rayaisse.consultationservice.service.client;

import com.wendyam_rayaisse.consultationservice.dto.MedecinDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class MedecinServiceFallback implements MedecinServiceFeignClient {
    @Override
    public ResponseEntity<MedecinDto> fetchMedecinInfoDetailsByMatricule(String matricule) {
        return null;
    }

    @Override
    public ResponseEntity<MedecinDto> fetchMedecinInfoDetailsById(String correlationId, int medecinId) {
        return null;
    }
}
