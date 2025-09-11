package com.wendyam_rayaisse.consultationservice.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "consultation-service")
@Setter
@Getter
public class ConsultationContactInfoDto {
    private String message;
    private Map<String, String> contactDetails;
    private String onCallSupport;
}
