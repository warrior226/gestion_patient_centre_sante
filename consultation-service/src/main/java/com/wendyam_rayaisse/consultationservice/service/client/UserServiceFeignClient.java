package com.wendyam_rayaisse.consultationservice.service.client;

import com.wendyam_rayaisse.consultationservice.dto.ResponseDto;
import com.wendyam_rayaisse.consultationservice.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient("patient-medecin-service")
public interface UserServiceFeignClient {
    @PostMapping(value = "/api/create",consumes = "application/json")
    public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody UserDto userDto);

    @GetMapping(value = "/api/fetchByUserId",consumes = "application/json")
    public ResponseEntity<UserDto> fetchUserId(@RequestHeader("healthcareApp-correlation-id")String correlationId, @RequestParam int userId);
}
