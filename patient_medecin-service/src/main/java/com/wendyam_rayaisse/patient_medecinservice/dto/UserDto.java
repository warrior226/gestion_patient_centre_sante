package com.wendyam_rayaisse.patient_medecinservice.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(
        name = "User",
        description = "Schema to hold User information"
)
public class UserDto {

    @NotNull
    private int patientId;

    @NotNull
    private int medecinId;
}
