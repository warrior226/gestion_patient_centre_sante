package com.wendyam_rayaisse.prescriptionservice.mapper;

import com.wendyam_rayaisse.prescriptionservice.dto.PrescriptionDto;
import com.wendyam_rayaisse.prescriptionservice.entity.Prescription;

public class PrescriptionMapper {

    public static PrescriptionDto mapToPrescriptionDto(PrescriptionDto prescriptionDto, Prescription prescription){
        prescriptionDto.setConsultationId(prescription.getConsultationId());
        prescriptionDto.setMedicament(prescription.getMedicament());
        prescriptionDto.setPosologie(prescription.getPosologie());

        return  prescriptionDto;
    }

    public static Prescription mapToPrescription(PrescriptionDto prescriptionDto, Prescription prescription){
        prescription.setConsultationId(prescriptionDto.getConsultationId());
        prescription.setMedicament(prescriptionDto.getMedicament());
        prescription.setPosologie(prescriptionDto.getPosologie());

        return  prescription;
    }


}
