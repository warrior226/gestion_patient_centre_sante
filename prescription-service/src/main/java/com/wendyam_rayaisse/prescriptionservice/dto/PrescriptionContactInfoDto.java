package com.wendyam_rayaisse.prescriptionservice.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "prescription-service")
@Setter
@Getter
public class PrescriptionContactInfoDto {
    private String message;
    private Map<String, String> contactDetails;
    private String onCallSupport;
}
