package com.wendyam_rayaisse.patient.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;


@Schema(name = "Patient", description = "Schema to hold patient information")
@Data
public class PatientDto {
    private String matricule;

    @NotEmpty(message="Vueillez renseigner le nom du patient")
    private String nom;

    @NotEmpty(message="Vueillez renseigner le prenom du patient")
    private String prenom;

    @Email(message="Vueillez renseigner un email valide")
    private String email;

    private String adresse;

    @Pattern(regexp="(^$|[0-9]{8,})",message="Le contact doit avoir au moins 8 chiffres")
    private String contact;

    private LocalDate dateNaissance;

    @NotEmpty(message="Vueillez renseigner le genre du patient")
    private  String genre;

    private String profession;

    @NotEmpty(message="Vueillez renseigner le mot de passe")
    @Size(min = 8, message="Le mot de passe doit avoir au moins 8 caracteres")
    private String password;

}
