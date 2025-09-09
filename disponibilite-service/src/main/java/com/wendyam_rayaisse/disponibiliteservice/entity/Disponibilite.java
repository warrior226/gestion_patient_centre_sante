package com.wendyam_rayaisse.disponibiliteservice.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
public class Disponibilite extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int disponibiliteId;

    @NotNull
    private int medecinId;

    @NotNull
    private LocalDate dateDisponibilite;

    @NotNull
    private LocalTime heureDebut;

    @NotNull
    private LocalTime heureDescente;
}
