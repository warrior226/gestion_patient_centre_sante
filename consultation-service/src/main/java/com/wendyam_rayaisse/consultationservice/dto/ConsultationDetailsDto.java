package com.wendyam_rayaisse.consultationservice.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Schema(
        name = "Consultation",
        description = "Schema contenant les informations d'une consultation,du medecin et du patient impliqué"
)
public class ConsultationDetailsDto {

    @NotNull
    private int userId;

    private LocalDate dateConsultation;

    private LocalTime heureConsultation;

    private String motifConsultation;

    private String antecedentsMedicaux;

    private String antecedentsFamiliaux;

    private String allergies;

    private String symptomes;


    private String traitementEnCours;


    private String observation;


    private String recommandation;

    private LocalDate dateProchaineVisite;

    @Schema(
            description = "Medecin details"
    )
    private MedecinDto medecinDto;

    @Schema(
            description = "Patient details"
    )
    private PatientDto patientDto;

}
