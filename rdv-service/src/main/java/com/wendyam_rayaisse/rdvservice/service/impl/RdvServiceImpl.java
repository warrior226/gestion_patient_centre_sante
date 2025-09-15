package com.wendyam_rayaisse.rdvservice.service.impl;


import com.wendyam_rayaisse.rdvservice.dto.RdvDto;
import com.wendyam_rayaisse.rdvservice.entity.Rdv;
import com.wendyam_rayaisse.rdvservice.exception.ResourceNotFoundException;
import com.wendyam_rayaisse.rdvservice.mapper.RdvMapper;
import com.wendyam_rayaisse.rdvservice.repository.RdvRepository;
import com.wendyam_rayaisse.rdvservice.service.IRdvService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RdvServiceImpl implements IRdvService {
    private RdvRepository rdvRepository;
    @Override
    public void createRdv(RdvDto rdvDto) {
        Rdv rdv = RdvMapper.mapToRdv(rdvDto,new Rdv());
        rdvRepository.save(rdv);
    }

    @Override
    public boolean deleteByRdvId(int rdvId) {
        Rdv rdv =rdvRepository.findByRdvId(rdvId).orElseThrow(
                ()-> new ResourceNotFoundException("Aucune information disponible")
        );
        rdvRepository.deleteByRdvId(rdvId);
        return true;
    }

    @Override
    public List<RdvDto> findByUserId(int userId) {
        List<Rdv> rdvList=rdvRepository.findByUserId(userId).orElseThrow(
                ()-> new ResourceNotFoundException("Aucun rendez-vous en cours")
        );
        List<RdvDto> rdvDtoList = new ArrayList<>();
        for(Rdv rdv : rdvList){
            rdvDtoList.add(RdvMapper.mapToRdvDto(new RdvDto(),rdv));
        }
        return rdvDtoList;
    }

    @Override
    public boolean updateRdv(RdvDto rdvDto) {
        Rdv rdv =rdvRepository.findByRdvId(rdvDto.getRdvId()).orElseThrow(
                ()-> new ResourceNotFoundException("Aucune information disponible")
        );
        rdvRepository.save(RdvMapper.mapToRdv(rdvDto,rdv));
        return true;
    }
}
