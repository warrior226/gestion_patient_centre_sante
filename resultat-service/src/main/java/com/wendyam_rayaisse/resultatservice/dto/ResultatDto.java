package com.wendyam_rayaisse.resultatservice.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(
        name = "Resultats",
        description = "Schema contant les différents resultats"
)
public class ResultatDto {

    @NotNull
    private int resultatId;

    @NotNull
    private int examenId;

    @NotNull
    private String resultat;

    @NotNull
    private String interpretation;

    private String resultatFilePath;
}
