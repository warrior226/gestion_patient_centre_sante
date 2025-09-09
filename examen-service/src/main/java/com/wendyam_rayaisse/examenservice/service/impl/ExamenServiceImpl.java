package com.wendyam_rayaisse.examenservice.service.impl;

import com.wendyam_rayaisse.examenservice.dto.ExamenDto;
import com.wendyam_rayaisse.examenservice.entity.Examen;
import com.wendyam_rayaisse.examenservice.exception.ResourceNotFoundException;
import com.wendyam_rayaisse.examenservice.mapper.ExamenMapper;
import com.wendyam_rayaisse.examenservice.repository.ExamenRepository;
import com.wendyam_rayaisse.examenservice.service.IExamenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ExamenServiceImpl implements IExamenService {
    private ExamenRepository examenRepository;
    @Override
    public void createExamen(ExamenDto examenDto) {
        Examen examen = ExamenMapper.mapToExamen(examenDto,new Examen());
        examenRepository.save(examen);
    }

    @Override
    public boolean updateExamen(ExamenDto examenDto) {
        Examen examen = examenRepository.findByConsultationId(examenDto.getConsultationId()).orElseThrow(
                ()-> new ResourceNotFoundException("Aucune information trouvée")
        );
        examen.setNomExamen(examen.getNomExamen());
        examen.setTypeExamen(examen.getTypeExamen());
        return true;
    }

    @Override
    public boolean deleteExamen(int consultationId) {
        Examen examen = examenRepository.findByConsultationId(consultationId).orElseThrow(
                ()-> new ResourceNotFoundException("Aucune information trouvée")
        );
        examenRepository.deleteByConsultationId(examen.getConsultationId());
        return true;
    }

    @Override
    public List<ExamenDto> getAllExamen(int consultationId) {
        List<Examen> listOfExamen=examenRepository.findByConsultationIdContaining(consultationId);
        List<ExamenDto> examenDtoList=new ArrayList<>();
        for(Examen examen : listOfExamen){
            examenDtoList.add(ExamenMapper.mapToDto(new ExamenDto(),examen));
        }
        return examenDtoList;
    }
}
