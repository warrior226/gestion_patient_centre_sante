package com.wendyam_rayaisse.constanteservice.mapper;

import com.wendyam_rayaisse.constanteservice.dto.ConstanteDto;
import com.wendyam_rayaisse.constanteservice.entity.Constantes;

public class ConstantesMapper {

    public static ConstanteDto mapToDto(Constantes constantes,ConstanteDto constanteDto){
        constanteDto.setConstantesId(constantes.getConstantesId());
        constanteDto.setPatientId(constantes.getPatientId());
        constanteDto.setPoids(constantes.getPoids());
        constanteDto.setTaille(constantes.getTaille());
        constanteDto.setTemperature(constantes.getTemperature());
        constanteDto.setTensionSystolique(constantes.getTensionSystolique());
        constanteDto.setTensionDiastolique(constantes.getTensionDiastolique());
        constanteDto.setFrequenceCardiaque(constantes.getFrequenceCardiaque());
        constanteDto.setFrequenceRespiratoire(constantes.getFrequenceRespiratoire());
        constanteDto.setGroupeSanguin(constantes.getGroupeSanguin());
        return constanteDto;
    }

    public static Constantes mapToConstant(Constantes constantes,ConstanteDto constanteDto){
        constantes.setConstantesId(constanteDto.getConstantesId());
        constantes.setPatientId(constanteDto.getPatientId());
        constantes.setPoids(constanteDto.getPoids());
        constantes.setTaille(constanteDto.getTaille());
        constantes.setTemperature(constanteDto.getTemperature());
        constantes.setTensionSystolique(constanteDto.getTensionSystolique());
        constantes.setTensionDiastolique(constanteDto.getTensionDiastolique());
        constantes.setFrequenceCardiaque(constanteDto.getFrequenceCardiaque());
        constantes.setFrequenceRespiratoire(constanteDto.getFrequenceRespiratoire());
        constantes.setGroupeSanguin(constanteDto.getGroupeSanguin());
        return constantes;
    }
}
