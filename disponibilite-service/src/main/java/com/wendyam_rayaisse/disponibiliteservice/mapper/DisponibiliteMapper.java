package com.wendyam_rayaisse.disponibiliteservice.mapper;

import com.wendyam_rayaisse.disponibiliteservice.dto.DisponibiliteDto;
import com.wendyam_rayaisse.disponibiliteservice.entity.Disponibilite;

public class DisponibiliteMapper {

    public static DisponibiliteDto mapToDisponibiliteDto(Disponibilite disponibilite,DisponibiliteDto disponibiliteDto){
        disponibiliteDto.setDisponibiliteId(disponibilite.getDisponibiliteId());
        disponibiliteDto.setMedecinId(disponibilite.getMedecinId());
        disponibiliteDto.setDateDisponibilite(disponibilite.getDateDisponibilite());
        disponibiliteDto.setHeureDebut(disponibilite.getHeureDebut());
        disponibiliteDto.setHeureDescente(disponibilite.getHeureDescente());
        return  disponibiliteDto;
    }

    public static  Disponibilite mapToDisponibilite(Disponibilite disponibilite, DisponibiliteDto disponibiliteDto){
        disponibilite.setDisponibiliteId(disponibiliteDto.getDisponibiliteId());
        disponibilite.setMedecinId(disponibiliteDto.getMedecinId());
        disponibilite.setDateDisponibilite(disponibiliteDto.getDateDisponibilite());
        disponibilite.setHeureDebut(disponibiliteDto.getHeureDebut());
        disponibilite.setHeureDescente(disponibiliteDto.getHeureDescente());
        return disponibilite;
    }
}
