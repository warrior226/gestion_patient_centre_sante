package com.wendyam_rayaisse.prescriptionservice;

import com.wendyam_rayaisse.prescriptionservice.dto.PrescriptionContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Documentation avec les APIs du microservice Prescription",
                description = " microservice Prescription REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "RAYAISSE Patrick Renaud Wendyam",
                        email = "rayaissewendyam@gmail.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description =  "Documentation avec les APIs du microservice patient",
                url = "http://localhost:4007/swagger-ui/index.html"
        )
)
@EnableConfigurationProperties(value = {PrescriptionContactInfoDto.class})
public class PrescriptionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrescriptionServiceApplication.class, args);
    }

}
