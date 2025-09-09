package com.wendyam_rayaisse.rdvservice.mapper;

import com.wendyam_rayaisse.rdvservice.dto.RdvDto;
import com.wendyam_rayaisse.rdvservice.entity.Rdv;

public class RdvMapper {

    public static RdvDto mapToRdvDto(RdvDto rdvDto,Rdv rdv){
        rdvDto.setRdvId(rdv.getRdvId());
        rdvDto.setUserId(rdv.getUserId());
        rdvDto.setDateRdv(rdv.getDateRdv());
        rdvDto.setHeureRdv(rdv.getHeureRdv());
        rdvDto.setMotifConsultation(rdv.getMotifConsultation());
        rdvDto.setStatus(rdv.getStatus());
        return rdvDto;
    }

    public static Rdv mapToRdv(RdvDto rdvDto,Rdv rdv){
        rdv.setRdvId(rdvDto.getRdvId());
        rdv.setUserId(rdvDto.getUserId());
        rdv.setDateRdv(rdvDto.getDateRdv());
        rdv.setHeureRdv(rdvDto.getHeureRdv());
        rdv.setMotifConsultation(rdvDto.getMotifConsultation());
        rdv.setStatus(rdvDto.getStatus());
        return rdv;
    }
}
