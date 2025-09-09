package com.wendyam_rayaisse.prescriptionservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;

@Data
@Schema(
        name = "Prescription",
        description = "Schema to hold "
)
public class PrescriptionDto {
    @NotNull
    private int consultationId;

    @NotNull
    private String medicament;

    @NotNull
    private String posologie;
}
