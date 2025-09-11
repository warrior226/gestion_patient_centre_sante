package com.wendyam_rayaisse.medecinservice.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "medecine-service")
@Setter
@Getter
public class MedecinContactInfoDto {
    private String message;
    private Map<String, String> contactDetails;
    private String onCallSupport;
}
