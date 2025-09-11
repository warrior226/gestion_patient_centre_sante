package com.wendyam_rayaisse.rdvservice.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "rdv-service")
@Setter
@Getter
public class RdvContactInfoDto {
    private String message;
    private Map<String, String> contactDetails;
    private String onCallSupport;
}
