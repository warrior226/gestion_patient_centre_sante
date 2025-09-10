package com.wendyam_rayaisse.constanteservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(
        name = "Constante",
        description = "Objet contenant les informations sur les constantes d'une patiente"
)
public class ConstanteDto {

    @NotNull
    private int constantesId;

    @NotNull
    private int patientId;

    private Double poids;

    private Double taille;

    private Double temperature;

    private Integer tensionSystolique;

    private Integer tensionDiastolique;

    private Integer frequenceCardiaque;

    private Integer frequenceRespiratoire;

    private String groupeSanguin;
}
