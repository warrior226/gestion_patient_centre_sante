package com.wendyam_rayaisse.resultatservice.mapper;

import com.wendyam_rayaisse.resultatservice.dto.ResultatDto;
import com.wendyam_rayaisse.resultatservice.entity.Resultat;

public class ResultatMapper {

    public static ResultatDto mapToDto(ResultatDto resultatDto, Resultat resultat){
         resultatDto.setResultat(resultat.getResultat());
         resultatDto.setInterpretation(resultat.getInterpretation());
         return resultatDto;
    }


    public static Resultat mapToResultat(ResultatDto resultatDto, Resultat resultat){
         resultat.setResultat(resultatDto.getResultat());
         resultat.setInterpretation(resultatDto.getInterpretation());
         resultat.setResultatFilePath(resultatDto.getResultatFilePath());
         return resultat;
    }
}
