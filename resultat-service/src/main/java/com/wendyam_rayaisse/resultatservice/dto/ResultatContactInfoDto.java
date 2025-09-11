package com.wendyam_rayaisse.resultatservice.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "resultat-service")
@Setter
@Getter
public class ResultatContactInfoDto {
    private String message;
    private Map<String, String> contactDetails;
    private String onCallSupport;
}
