package com.wendyam_rayaisse.rdvservice.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Schema(
        name = "Rdv",
        description = "Schema to hold Rdv information"
)
public class RdvDto {

    @NotNull
    private int rdvId;
    @NotNull
    private int userId;

    @NotNull
    private LocalDate dateRdv;

    @NotNull
    private LocalTime heureRdv;

    @NotNull
    private String  motifConsultation;

    private String status;
}
