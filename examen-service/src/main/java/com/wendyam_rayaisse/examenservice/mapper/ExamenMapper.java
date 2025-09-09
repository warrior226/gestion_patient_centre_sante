package com.wendyam_rayaisse.examenservice.mapper;

import com.wendyam_rayaisse.examenservice.dto.ExamenDto;
import com.wendyam_rayaisse.examenservice.entity.Examen;

public class ExamenMapper {

    public static ExamenDto mapToDto(ExamenDto examenDto, Examen examen){
        examenDto.setConsultationId(examen.getConsultationId());
        examenDto.setNomExamen(examen.getNomExamen());
        examenDto.setTypeExamen(examen.getTypeExamen());
        return examenDto;
    }
    public static Examen mapToExamen(ExamenDto examenDto, Examen examen){
        examen.setConsultationId(examen.getConsultationId());
        examen.setNomExamen(examen.getNomExamen());
        examen.setTypeExamen(examen.getTypeExamen());
        return examen;
    }
}
