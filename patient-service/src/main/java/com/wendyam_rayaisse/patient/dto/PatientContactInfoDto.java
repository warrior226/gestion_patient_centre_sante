package com.wendyam_rayaisse.patient.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "patient-service")
@Setter
@Getter
public class PatientContactInfoDto {
    private String message;
    private Map<String, String> contactDetails;
    private String onCallSupport;
}
