package com.wendyam_rayaisse.constanteservice.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "constante-service")
@Setter
@Getter
public class ConstanteContactInfoDto {
    private String message;
    private Map<String, String> contactDetails;
    private String onCallSupport;
}
