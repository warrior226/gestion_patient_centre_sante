package com.wendyam_rayaisse.consultationservice.service.impl;


import com.wendyam_rayaisse.consultationservice.dto.*;
import com.wendyam_rayaisse.consultationservice.entity.Consultation;
import com.wendyam_rayaisse.consultationservice.exception.ResourceNotFoundException;
import com.wendyam_rayaisse.consultationservice.mapper.ConsultationMapper;
import com.wendyam_rayaisse.consultationservice.repository.ConsultationRepository;
import com.wendyam_rayaisse.consultationservice.service.IConsultationDetailService;
import com.wendyam_rayaisse.consultationservice.service.client.MedecinServiceFeignClient;
import com.wendyam_rayaisse.consultationservice.service.client.PatientServiceFeignClient;
import com.wendyam_rayaisse.consultationservice.service.client.UserServiceFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsultationDetailsServiceImpl implements IConsultationDetailService {
    private ConsultationRepository consultationRepository;
    private MedecinServiceFeignClient medecinServiceFeignClient;
    private PatientServiceFeignClient patientServiceFeignClient;
    private UserServiceFeignClient userServiceFeignClient;
    @Override
    public ConsultationDetailsDto fetchConsultationDetailsByUserId(int consultationId) {
        Consultation consultation = consultationRepository.findByConsultationId(consultationId).orElseThrow(
                ()-> new ResourceNotFoundException("Aucune information disponible")
        );

        ConsultationDetailsDto consultationDetailsDto = ConsultationMapper.mapToConsultationDetailsDto(consultation,new ConsultationDetailsDto());

        ResponseEntity<UserDto> userDtoResponseEntity=userServiceFeignClient.fetchUserId(consultation.getUserId());
        assert userDtoResponseEntity.getBody() != null;
        ResponseEntity<MedecinDto> medecinDtoResponseEntity=medecinServiceFeignClient.fetchMedecinInfoDetailsById(userDtoResponseEntity.getBody().getMedecinId());
        consultationDetailsDto.setMedecinDto(medecinDtoResponseEntity.getBody());

        ResponseEntity<PatientDto> patientDtoResponseEntity=patientServiceFeignClient.fetchPatientInfoDetailsById(userDtoResponseEntity.getBody().getPatientId());
        consultationDetailsDto.setPatientDto(patientDtoResponseEntity.getBody());

        return consultationDetailsDto;
    }
}
