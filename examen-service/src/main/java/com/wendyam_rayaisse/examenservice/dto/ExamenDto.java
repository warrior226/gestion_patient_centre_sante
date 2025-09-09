package com.wendyam_rayaisse.examenservice.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(
        name = "Examens",
        description = "Schema contenant les informations Examen"
)
public class ExamenDto {
    @NotNull
    private int consultationId;

    @NotNull
    private String nomExamen;

    @NotNull
    private String typeExamen;
}
