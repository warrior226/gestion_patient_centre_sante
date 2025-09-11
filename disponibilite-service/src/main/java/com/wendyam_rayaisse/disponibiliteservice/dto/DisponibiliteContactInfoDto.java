package com.wendyam_rayaisse.disponibiliteservice.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "disponibilite-service")
@Setter
@Getter
public class DisponibiliteContactInfoDto {
    private String message;
    private Map<String, String> contactDetails;
    private String onCallSupport;
}
