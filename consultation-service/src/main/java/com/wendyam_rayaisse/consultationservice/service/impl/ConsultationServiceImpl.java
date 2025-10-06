package com.wendyam_rayaisse.consultationservice.service.impl;

import com.wendyam_rayaisse.consultationservice.dto.ConsultationDto;
import com.wendyam_rayaisse.consultationservice.dto.ConsultationMsgDto;
import com.wendyam_rayaisse.consultationservice.entity.Consultation;
import com.wendyam_rayaisse.consultationservice.exception.ResourceNotFoundException;
import com.wendyam_rayaisse.consultationservice.mapper.ConsultationMapper;
import com.wendyam_rayaisse.consultationservice.repository.ConsultationRepository;
import com.wendyam_rayaisse.consultationservice.service.IConsultationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ConsultationServiceImpl implements IConsultationService {
    private ConsultationRepository consultationRepository;
    private static final Logger log = LoggerFactory.getLogger(ConsultationServiceImpl.class);
    private final StreamBridge streamBridge;
    @Override
    public void createConsultation(ConsultationDto consultationDto) {
        Consultation consultation = ConsultationMapper.mapToConsultation(consultationDto,new Consultation());
        consultationRepository.save(consultation);
        sendConsultation(consultation);
    }

    private void sendConsultation(Consultation consultation){
        var consultationMsgDto = new ConsultationMsgDto(
                1L,
                "RAYAISSE Patrick",
                "+226 65272174",
                "rayaissewendyam@gmail.com"
        );
        log.info("Sending consultation request for the details: {}", consultationMsgDto);
        var result = streamBridge.send("sendCommunication-out-0",consultationMsgDto);
        log.info("Result: {}", result);
    }

    @Override
    public List<ConsultationDto> getUserById(int userId) {
        List<Consultation> listconsultation =  consultationRepository.findByUserId(userId).orElseThrow(
                ()->new ResourceNotFoundException("Aucune information disponible")
        );
        List<ConsultationDto> consultationDtoList = new ArrayList<>();
        for(Consultation element : listconsultation ){
            consultationDtoList.add(ConsultationMapper.mapToConsultationDto(new ConsultationDto(),element));
        }
        return consultationDtoList;
    }

    @Override
    public boolean updateConsultation(ConsultationDto consultationDto) {
        Consultation consultation = consultationRepository.findByConsultationId(consultationDto.getConsultationId()).orElseThrow(
                ()-> new ResourceNotFoundException("Aucune information disponible")
        );

        consultationRepository.save(ConsultationMapper.mapToConsultation(consultationDto,consultation));
        return true;
    }

    @Override
    public boolean deleteConsultation(int consultationId) {
        Consultation consultation = consultationRepository.findByConsultationId(consultationId).orElseThrow(
                ()-> new ResourceNotFoundException("Aucune information disponible")
        );
        consultationRepository.deleteByConsultationId(consultation.getConsultationId());
        return true;
    }

    @Override
    public List<ConsultationDto> getAllConsultation(int userId) {
        List<Consultation> consultationList = consultationRepository.findByUserId(userId).orElseThrow(
                ()->new ResourceNotFoundException("Aucune consultation prévue pour ce patient")
        );
        List<ConsultationDto> consultationDtoList = new ArrayList<>();
        for (Consultation consultation : consultationList) {
            consultationDtoList.add(ConsultationMapper.mapToConsultationDto(new ConsultationDto(),consultation));
        }
        return consultationDtoList;
    }
}
