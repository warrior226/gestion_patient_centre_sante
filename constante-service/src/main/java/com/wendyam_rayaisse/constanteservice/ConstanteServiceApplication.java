package com.wendyam_rayaisse.constanteservice;

import com.wendyam_rayaisse.constanteservice.dto.ConstanteContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Documentation avec les APIs du microservice constante",
                description = " microservice rdv REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "RAYAISSE Patrick Renaud Wendyam",
                        email = "rayaissewendyam@gmail.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description =  "Documentation avec les APIs du microservice constante",
                url = "http://localhost:4005/swagger-ui/index.html"
        )
)
@EnableConfigurationProperties(value = {ConstanteContactInfoDto.class})
public class ConstanteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConstanteServiceApplication.class, args);
    }

}
