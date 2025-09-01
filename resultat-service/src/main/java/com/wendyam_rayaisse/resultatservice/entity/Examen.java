package com.wendyam_rayaisse.resultatservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Examen extends BaseEntity {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private UUID examenId;

    @NotNull
    private String resultat;

    @NotNull
    private String interpretation;

    private String resultatFile;

}
