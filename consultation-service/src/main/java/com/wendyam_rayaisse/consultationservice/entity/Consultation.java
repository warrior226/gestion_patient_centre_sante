package com.wendyam_rayaisse.consultationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Consultation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int consultationId;

    @NotNull
    private int userId;

    @NotNull
    private LocalDate dateConsultation;

    @NotNull
    private LocalTime heureConsultation;

    @NotNull
    private String motifConsultation;

    @NotNull
    private String antecedentsMedicaux;

    @NotNull
    private String antecedentsFamiliaux;

    @NotNull
    private String allergies;

    @NotNull
    private String symptomes;

    private String traitementEnCours;

    private String observation;

    private String recommandation;

    private LocalDate dateProchaineVisite;
}
