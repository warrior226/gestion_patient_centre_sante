package com.wendyam_rayaisse.medecinservice.service.Impl;

import com.wendyam_rayaisse.medecinservice.constants.MedecinConstants;
import com.wendyam_rayaisse.medecinservice.dto.MedecinDto;
import com.wendyam_rayaisse.medecinservice.entity.Medecin;
import com.wendyam_rayaisse.medecinservice.exception.ResourceNotFoundException;
import com.wendyam_rayaisse.medecinservice.mapper.MedecinMapper;
import com.wendyam_rayaisse.medecinservice.repository.MedecinRepository;
import com.wendyam_rayaisse.medecinservice.service.IMedecinService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class MedecinServiceImpl implements IMedecinService {
    private MedecinRepository medecinRepository;
    @Override
    public void createMedecin(MedecinDto medecinDto) {
        medecinDto.setStatus(true);
        medecinDto.setMatricule(MedecinConstants.generateMatricule(medecinDto.getNom(),medecinDto.getPrenom(),medecinDto.getSpecialite()));
        System.out.println("MedecinDto data to save:"+medecinDto);
        Medecin medecin= MedecinMapper.mapMedecinDtoToMedecinEntity(medecinDto,new Medecin());
        System.out.println("Patient data to save:"+medecin);
        medecinRepository.save(medecin);
    }

    @Override
    public MedecinDto getMedecinById(int patientId) {
        Medecin medecin = medecinRepository.findByMedecinId(patientId).orElseThrow(
                ()-> new ResourceNotFoundException("Cet utilisateur n'existe pas dans notre base donnée")
        );
        return MedecinMapper.mapMedecinEntityToMedecinDto(new MedecinDto(),medecin);
    }

    @Override
    public MedecinDto getMedecinByMatricule(String matricule) {
        Medecin medecin = medecinRepository.findByMatricule(matricule).orElseThrow(
                ()-> new ResourceNotFoundException("Cet utilisateur n'existe pas dans notre base donnée")
        );
        return MedecinMapper.mapMedecinEntityToMedecinDto(new MedecinDto(),medecin);
    }

    @Override
    public boolean updateMedecin(MedecinDto medecinDto) {
        Medecin medecin=medecinRepository.findByMatricule(medecinDto.getMatricule()).orElseThrow(
                ()-> new ResourceNotFoundException("Cet utilisateur n'existe pas dans notre base donnée")
        );
        medecin.setNom(medecinDto.getNom());
        medecin.setPrenom(medecinDto.getPrenom());
        medecin.setEmail(medecinDto.getEmail());
        medecin.setAdresse(medecinDto.getAdresse());
        medecin.setContact(medecinDto.getContact());
        medecin.setDateNaissance(medecinDto.getDateNaissance());
        medecin.setGenre(medecinDto.getGenre());
        medecin.setSpecialite(medecinDto.getSpecialite());
        medecinRepository.save(medecin);
        return true;
    }

    @Override
    public boolean deleteMedecinById(int patientId) {
        Medecin medecin=medecinRepository.findByMedecinId(patientId).orElseThrow(
                ()->new ResourceNotFoundException("Ce matricule n'existe pas dans notre base de donnee")
        );
        medecinRepository.deleteById(medecin.getMedecinId());
        return true;
    }

    @Override
    public boolean deleteMedecinByMatricule(String matricule) {
        Medecin medecin=medecinRepository.findByMatricule(matricule).orElseThrow(
                ()->new ResourceNotFoundException("Ce matricule n'existe pas dans notre base de donnee")
        );
        medecinRepository.deleteByMatricule(medecin.getMatricule());
        return true;
    }
}
