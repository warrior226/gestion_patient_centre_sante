package com.wendyam_rayaisse.examenservice.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "examen-service")
@Setter
@Getter
public class ExamenContactInfoDto {
    private String message;
    private Map<String, String> contactDetails;
    private String onCallSupport;
}
