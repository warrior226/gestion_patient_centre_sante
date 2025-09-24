package com.wendyam_rayaisse.consultationservice.service.client;

import com.wendyam_rayaisse.consultationservice.dto.MedecinDto;
import com.wendyam_rayaisse.consultationservice.dto.ResponseDto;
import com.wendyam_rayaisse.consultationservice.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallback implements UserServiceFeignClient {

    @Override
    public ResponseEntity<ResponseDto> createUser(UserDto userDto) {
        return null;
    }

    @Override
    public ResponseEntity<UserDto> fetchUserId(String correlationId, int userId) {
        return null;
    }
}
