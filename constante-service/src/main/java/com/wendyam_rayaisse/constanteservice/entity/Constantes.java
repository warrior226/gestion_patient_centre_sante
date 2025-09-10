package com.wendyam_rayaisse.constanteservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Constantes extends  BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int constantesId;

    private int patientId;

    private Double poids;

    private  Double taille;

    private Double temperature;

    private Integer tensionSystolique;

    private Integer tensionDiastolique;

    private Integer frequenceCardiaque;

    private Integer frequenceRespiratoire;

    private String groupeSanguin;




}
