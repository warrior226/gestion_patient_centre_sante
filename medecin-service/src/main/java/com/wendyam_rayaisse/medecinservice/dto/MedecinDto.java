package com.wendyam_rayaisse.medecinservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Schema(name = "medecin", description = "Schema to hold medecin information")
@Data
public class MedecinDto {
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

    private String dateNaissance;

    @NotEmpty(message="Vueillez renseigner le genre du patient")
    private  String genre;

    private String specialite;

    @NotEmpty(message="Vueillez renseigner le mot de passe")
    @Size(min = 8, message="Le mot de passe doit avoir au moins 8 caracteres")
    private String password;

    private boolean status;

}
