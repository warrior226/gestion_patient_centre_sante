package com.wendyam_rayaisse.consultationservice.mapper;

import com.wendyam_rayaisse.consultationservice.dto.ConsultationDetailsDto;
import com.wendyam_rayaisse.consultationservice.dto.ConsultationDto;
import com.wendyam_rayaisse.consultationservice.entity.Consultation;

public class ConsultationMapper {

    public static ConsultationDto mapToConsultationDto(ConsultationDto consultationDto,Consultation consultation){
        consultationDto.setConsultationId(consultation.getConsultationId());
        consultationDto.setUserId(consultation.getUserId());
        consultationDto.setDateConsultation(consultation.getDateConsultation());
        consultationDto.setHeureConsultation(consultation.getHeureConsultation());
        consultationDto.setMotifConsultation(consultation.getMotifConsultation());
        consultationDto.setAntecedentsMedicaux(consultation.getAntecedentsMedicaux());
        consultationDto.setAntecedentsFamiliaux(consultation.getAntecedentsFamiliaux());
        consultationDto.setAllergies(consultation.getAllergies());
        consultationDto.setSymptomes(consultation.getSymptomes());
        consultationDto.setTraitementEnCours(consultation.getTraitementEnCours());
        consultationDto.setObservation(consultation.getObservation());
        consultationDto.setRecommandation(consultation.getRecommandation());
        consultationDto.setDateProchaineVisite(consultation.getDateProchaineVisite());
        return  consultationDto;
    }


    public static Consultation mapToConsultation(ConsultationDto consultationDto,Consultation consultation){
        consultation.setConsultationId(consultationDto.getConsultationId());
        consultation.setUserId(consultationDto.getUserId());
        consultation.setDateConsultation(consultationDto.getDateConsultation());
        consultation.setHeureConsultation(consultationDto.getHeureConsultation());
        consultation.setMotifConsultation(consultationDto.getMotifConsultation());
        consultation.setAntecedentsMedicaux(consultationDto.getAntecedentsMedicaux());
        consultation.setAntecedentsFamiliaux(consultationDto.getAntecedentsFamiliaux());
        consultation.setAllergies(consultationDto.getAllergies());
        consultation.setSymptomes(consultationDto.getSymptomes());
        consultation.setTraitementEnCours(consultationDto.getTraitementEnCours());
        consultation.setObservation(consultationDto.getObservation());
        consultation.setRecommandation(consultationDto.getRecommandation());
        consultation.setDateProchaineVisite(consultationDto.getDateProchaineVisite());
        return  consultation;
    }

    public  static ConsultationDetailsDto mapToConsultationDetailsDto(Consultation consultation,ConsultationDetailsDto consultationDetailsDto){
        consultationDetailsDto.setUserId(consultation.getUserId());
        consultationDetailsDto.setDateConsultation(consultation.getDateConsultation());
        consultationDetailsDto.setHeureConsultation(consultation.getHeureConsultation());
        consultationDetailsDto.setMotifConsultation(consultation.getMotifConsultation());
        consultationDetailsDto.setAntecedentsMedicaux(consultation.getAntecedentsMedicaux());
        consultationDetailsDto.setAntecedentsFamiliaux(consultation.getAntecedentsFamiliaux());
        consultationDetailsDto.setAllergies(consultation.getAllergies());
        consultationDetailsDto.setSymptomes(consultation.getSymptomes());
        consultationDetailsDto.setTraitementEnCours(consultation.getTraitementEnCours());
        consultationDetailsDto.setObservation(consultation.getObservation());
        consultationDetailsDto.setRecommandation(consultation.getRecommandation());
        consultationDetailsDto.setDateProchaineVisite(consultation.getDateProchaineVisite());
        return consultationDetailsDto;
    }
}
