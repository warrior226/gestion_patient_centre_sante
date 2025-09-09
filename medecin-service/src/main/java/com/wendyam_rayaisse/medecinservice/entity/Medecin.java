package com.wendyam_rayaisse.medecinservice.entity;

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
public class Medecin extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medecinId;

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

    @NotNull
    private String specialite;

    @NotNull
    private String password;

    private boolean status=false;
}
