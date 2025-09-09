package com.wendyam_rayaisse.prescriptionservice.service.impl;

import com.wendyam_rayaisse.prescriptionservice.dto.PrescriptionDto;
import com.wendyam_rayaisse.prescriptionservice.entity.Prescription;
import com.wendyam_rayaisse.prescriptionservice.exception.ResourceNotFoundException;
import com.wendyam_rayaisse.prescriptionservice.mapper.PrescriptionMapper;
import com.wendyam_rayaisse.prescriptionservice.repository.PrescriptionRepository;
import com.wendyam_rayaisse.prescriptionservice.service.IPrescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PrescriptionServiceImpl implements IPrescriptionService {

    private PrescriptionRepository prescriptionRepository;
    @Override
    public void createPrescription(PrescriptionDto prescriptionDto) {
        Prescription prescription = PrescriptionMapper.mapToPrescription(prescriptionDto,new Prescription());
        prescriptionRepository.save(prescription);

    }

    @Override
    public boolean updatePrescription(PrescriptionDto prescriptionDto) {
        Prescription prescription = prescriptionRepository.findByConsultationId(prescriptionDto.getConsultationId()).orElseThrow(
                ()-> new ResourceNotFoundException("Aucune information trouvée")
        );
       prescription.setMedicament(prescriptionDto.getMedicament());
       prescription.setPosologie(prescriptionDto.getPosologie());
        return true;
    }

    @Override
    public boolean deletePrescription(int consultationId) {
        Prescription prescription = prescriptionRepository.findByConsultationId(consultationId).orElseThrow(
                ()-> new ResourceNotFoundException("Aucune information trouvée")
        );
        prescriptionRepository.deleteByConsultationId(consultationId);
        return true;
    }

    @Override
    public List<PrescriptionDto> getAllPrescription(int consultationId) {
        List<Prescription> listOfPrescription=prescriptionRepository.findByConsultationIdContaining(consultationId);
        List<PrescriptionDto> prescriptionDtoList=new ArrayList<>();
        for(Prescription prescription : listOfPrescription){
            prescriptionDtoList.add(PrescriptionMapper.mapToPrescriptionDto(new PrescriptionDto(),prescription));
        }
        return prescriptionDtoList;
    }
}
