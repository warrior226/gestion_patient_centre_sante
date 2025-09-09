package com.wendyam_rayaisse.prescriptionservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Prescription extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int prescriptionId;

    @NotNull
    private int  consultationId;

    @NotNull
    private String medicament;

    @NotNull
    private String posologie;
}
