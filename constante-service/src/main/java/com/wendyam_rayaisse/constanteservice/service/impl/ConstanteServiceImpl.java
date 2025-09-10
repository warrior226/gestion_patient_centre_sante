package com.wendyam_rayaisse.constanteservice.service.impl;

import com.wendyam_rayaisse.constanteservice.dto.ConstanteDto;
import com.wendyam_rayaisse.constanteservice.entity.Constantes;
import com.wendyam_rayaisse.constanteservice.exception.ResourceNotFoundException;
import com.wendyam_rayaisse.constanteservice.mapper.ConstantesMapper;
import com.wendyam_rayaisse.constanteservice.repository.ConstanteRepository;
import com.wendyam_rayaisse.constanteservice.service.IConstanteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConstanteServiceImpl implements IConstanteService {
    private ConstanteRepository constanteRepository;
    @Override
    public void createConstanteInfo(ConstanteDto constanteDto) {
        Constantes constantes = ConstantesMapper.mapToConstant(new Constantes(),constanteDto);
        constanteRepository.save(constantes);
    }

    @Override
    public boolean updateConstanteInfo(ConstanteDto constanteDto) {
        Constantes existingConstantes = constanteRepository.findByPatientId(constanteDto.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Aucune information disponible"));
        
        // Map the DTO to the existing entity, preserving the ID
        Constantes updatedConstantes = ConstantesMapper.mapToConstant(existingConstantes, constanteDto);
        constanteRepository.save(updatedConstantes);
        return true;
    }

    @Override
    public boolean deleteConstanteInfo(int patientId) {
        Constantes existingConstantes = constanteRepository.findByPatientId(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Aucune information disponible"));
        constanteRepository.delete(existingConstantes);
        return true;
    }
}
