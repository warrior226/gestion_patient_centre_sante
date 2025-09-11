package com.wendyam_rayaisse.resultatservice;

import com.wendyam_rayaisse.resultatservice.dto.ResultatContactInfoDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {ResultatContactInfoDto.class})
public class ResultatServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResultatServiceApplication.class, args);
    }

}
