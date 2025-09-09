package com.wendyam_rayaisse.rdvservice.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Rdv extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rdvId;

    @NotNull
    private int userId;

    @NotNull
    private LocalDate dateRdv;

    @NotNull
    private LocalTime heureRdv;

    @NotNull
    private String  motifConsultation;

    private String status;
}
