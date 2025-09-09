package com.wendyam_rayaisse.resultatservice.service.impl;


import com.wendyam_rayaisse.resultatservice.dto.ResultatDto;
import com.wendyam_rayaisse.resultatservice.entity.Resultat;
import com.wendyam_rayaisse.resultatservice.exception.ResourceNotFoundException;
import com.wendyam_rayaisse.resultatservice.mapper.ResultatMapper;
import com.wendyam_rayaisse.resultatservice.repository.ResultatRepository;
import com.wendyam_rayaisse.resultatservice.service.IResultatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ResultatServiceImpl implements IResultatService {

    private ResultatRepository resultatRepository;
    @Override
    public void createResultat(ResultatDto resultatDto) {
        Resultat resultat= ResultatMapper.mapToResultat(resultatDto,new Resultat());
        resultatRepository.save(resultat);
    }

    @Override
    public boolean updateResultat(ResultatDto resultatDto) {
        Resultat resultat = resultatRepository.findByExamenId(resultatDto.getExamenId()).orElseThrow(
                ()-> new ResourceNotFoundException("Aucune Information disponible")
        );
        resultat.setResultat(resultatDto.getResultat());
        resultat.setInterpretation(resultatDto.getInterpretation());
        return true;
    }

    @Override
    public boolean deleteResultat(int examenId) {
        Resultat resultat = resultatRepository.findByExamenId(examenId).orElseThrow(
                ()-> new ResourceNotFoundException("Aucune Information disponible")
        );
        resultatRepository.deleteByExamenId(resultat.getExamenId());
        return true;
    }

    @Override
    public List<ResultatDto> getAllResultat(int examenId) {
        List<Resultat> resultatList = resultatRepository.findByExamenIdContaining(examenId).orElseThrow(
                ()-> new ResourceNotFoundException("Aucune Information disponible")
        );
        List<ResultatDto> resultatDtoList= new ArrayList<>();
        for(Resultat resultat : resultatList){
            resultatDtoList.add(ResultatMapper.mapToDto(new ResultatDto(),resultat));
        }
        return resultatDtoList;
    }
}
