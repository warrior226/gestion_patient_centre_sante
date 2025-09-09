package com.wendyam_rayaisse.medecinservice.mapper;

import com.wendyam_rayaisse.medecinservice.dto.MedecinDto;
import com.wendyam_rayaisse.medecinservice.entity.Medecin;

public class MedecinMapper {

    public static MedecinDto mapMedecinEntityToMedecinDto(MedecinDto medecinDto, Medecin medecin){
        medecinDto.setNom(medecin.getNom());
        medecinDto.setMatricule(medecin.getMatricule());
        medecinDto.setPrenom(medecin.getPrenom());
        medecinDto.setEmail(medecin.getEmail());
        medecinDto.setAdresse(medecin.getAdresse());
        medecinDto.setContact(medecin.getContact());
        medecinDto.setDateNaissance(medecin.getDateNaissance());
        medecinDto.setGenre(medecin.getGenre());
        medecinDto.setSpecialite(medecin.getSpecialite());
        medecinDto.setStatus(medecin.isStatus());
        return medecinDto;
    }


    public static  Medecin mapMedecinDtoToMedecinEntity(MedecinDto medecinDto,Medecin medecin){
        medecin.setNom(medecinDto.getNom());
        medecin.setMatricule(medecinDto.getMatricule());
        medecin.setPrenom(medecinDto.getPrenom());
        medecin.setEmail(medecinDto.getEmail());
        medecin.setAdresse(medecinDto.getAdresse());
        medecin.setContact(medecinDto.getContact());
        medecin.setDateNaissance(medecinDto.getDateNaissance());
        medecin.setGenre(medecinDto.getGenre());
        medecin.setSpecialite(medecinDto.getSpecialite());
        medecin.setPassword(medecinDto.getPassword());
        medecin.setStatus(medecinDto.isStatus());
        return  medecin;
    }
}
