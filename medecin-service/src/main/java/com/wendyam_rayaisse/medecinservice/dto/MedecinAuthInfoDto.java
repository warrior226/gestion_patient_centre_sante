package com.wendyam_rayaisse.medecinservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(name = "Medecin", description = "Schema to hold patient information")
@Data
public class MedecinAuthInfoDto {
    private String matricule;
    @NotEmpty(message="Vueillez renseigner le mot de passe")
    @Size(min = 8, message="Le mot de passe doit avoir au moins 8 caracteres")
    private String password;
}
