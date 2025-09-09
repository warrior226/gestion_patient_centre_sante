package com.wendyam_rayaisse.disponibiliteservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Schema(
        name = "Disponibilite",
        description = "Schema to hold Disponibilite information"
)
public class DisponibiliteDto {
    @Schema(
            description="Id du medecin"
    )
    @NotNull
    private int disponibiliteId;

    @Schema(
            description="Id du medecin"
    )
    @NotNull
    private int medecinId;

    @Schema(
            description="Date de disponibilite du medecin"
    )
    @NotNull
    private LocalDate dateDisponibilite;


    @Schema(
            description="Heure initial de disponibilité du medecin"
    )
    @NotNull
    private LocalTime heureDebut;

    @Schema(
            description="Heure de fin de disponibilité du medecin"
    )
    @NotNull
    private LocalTime heureDescente;
}
