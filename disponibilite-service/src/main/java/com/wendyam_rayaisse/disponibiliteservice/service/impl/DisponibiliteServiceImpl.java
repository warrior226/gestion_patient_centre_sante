package com.wendyam_rayaisse.disponibiliteservice.service.impl;


import com.wendyam_rayaisse.disponibiliteservice.dto.DisponibiliteDto;
import com.wendyam_rayaisse.disponibiliteservice.entity.Disponibilite;
import com.wendyam_rayaisse.disponibiliteservice.exception.ResourceNotFoundException;
import com.wendyam_rayaisse.disponibiliteservice.mapper.DisponibiliteMapper;
import com.wendyam_rayaisse.disponibiliteservice.repository.DisponibiliteRepository;
import com.wendyam_rayaisse.disponibiliteservice.service.IDisponibiliteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DisponibiliteServiceImpl implements IDisponibiliteService {
    private DisponibiliteRepository disponibiliteRepository;
    @Override
    public void createDisponibilite(DisponibiliteDto disponibiliteDto) {
        Disponibilite disponibilite= DisponibiliteMapper.mapToDisponibilite(new Disponibilite(),disponibiliteDto);
        disponibiliteRepository.save(disponibilite);
    }

    @Override
    public List<DisponibiliteDto> fetchDisponibiliteByMedecinId(int medecinId) {
        List<Disponibilite> disponibilite = disponibiliteRepository.findByMedecinId(medecinId).orElseThrow(
                ()->new ResourceNotFoundException("Aucune informaion sur la disponibilite de ce medecin")
        );

        List<DisponibiliteDto> disponibiliteDtoList= new ArrayList<>();
        for(Disponibilite element : disponibilite){
            disponibiliteDtoList.add(DisponibiliteMapper.mapToDisponibiliteDto(element,new DisponibiliteDto()));
        }
        return disponibiliteDtoList;
    }

    @Override
    public boolean updateDisponibilite(DisponibiliteDto disponibiliteDto) {
        Disponibilite disponibilite=disponibiliteRepository.findByDisponibiliteId(disponibiliteDto.getDisponibiliteId()).orElseThrow(
                ()-> new ResourceNotFoundException("Aucune information n'a cet identifiant")
        );
        disponibilite.setDateDisponibilite(disponibiliteDto.getDateDisponibilite());
        disponibilite.setMedecinId(disponibiliteDto.getMedecinId());
        disponibilite.setHeureDebut(disponibiliteDto.getHeureDebut());
        disponibilite.setHeureDescente(disponibiliteDto.getHeureDescente());
        disponibiliteRepository.save(disponibilite);
        return true;
    }

    @Override
    public boolean deleteDispobibiliteByDisponibiliteId(int disponibiliteId) {
        Disponibilite disponibilite=disponibiliteRepository.findByDisponibiliteId(disponibiliteId).orElseThrow(
                ()-> new ResourceNotFoundException("Aucune information n'a cet identifiant")
        );
        disponibiliteRepository.deleteByMedecinId(disponibiliteId);
        return true;
    }
}
