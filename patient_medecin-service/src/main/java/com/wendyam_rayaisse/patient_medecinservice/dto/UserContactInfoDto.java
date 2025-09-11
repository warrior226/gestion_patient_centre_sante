package com.wendyam_rayaisse.patient_medecinservice.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "user-service")
@Setter
@Getter
public class UserContactInfoDto {
    private String message;
    private Map<String, String> contactDetails;
    private String onCallSupport;
}
