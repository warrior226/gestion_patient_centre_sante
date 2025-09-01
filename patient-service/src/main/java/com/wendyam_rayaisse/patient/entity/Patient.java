package com.wendyam_rayaisse.patient.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @NotNull
    private String matricule;

    @NotNull
    private String nom;

    @NotNull
    private String prenom;

    @Email
    @Column(unique = true)
    private String email;

    private String adresse;

    private String contact;

    private String dateNaissance;

    @NotNull
    private String genre;

    private String profession;

    private String password;

}
