package com.wendyam_rayaisse.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class  GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

    @Bean
    public RouteLocator gestionPatientRouteConfig(RouteLocatorBuilder routeLocatorBuilder){

        return routeLocatorBuilder.routes()
                .route(p->p
                        .path("/healthcareApp/medecin-service/**")
                        .filters(f->f.rewritePath("/healthcareApp/medecin-service/(?<segment>.*)","/${segment}")
                                .addRequestHeader("X-Response-Time", LocalDateTime.now().toString())
                                .circuitBreaker(config->config.setName("medecin-service-CircuitBreaker")
                                        .setFallbackUri("forward:/contactSupport"))
                        )
                        .uri("lb://MEDECIN-SERVICE"))
                .route(p->p
                        .path("/healthcareApp/patient-service/**")
                        .filters(f->f.rewritePath("/healthcareApp/patient-service/(?<segment>.*)","/${segment}")
                                .addRequestHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://PATIENT-SERVICE"))
                .route(p->p
                        .path("/healthcareApp/patient-medecin-service/**")
                        .filters(f->f.rewritePath("/healthcareApp/patient-medecin-service/(?<segment>.*)","/${segment}")
                                .addRequestHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://PATIENT-MEDECIN-SERVICE"))
                .route(p->p
                        .path("/healthcareApp/disponibilite-service/**")
                        .filters(f->f.rewritePath("/healthcareApp/disponibilite-service/(?<segment>.*)","/${segment}")
                                .addRequestHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://DISPONIBILITE-SERVICE"))
                .route(p->p
                        .path("/healthcareApp/rdv-service/**")
                        .filters(f->f.rewritePath("/healthcareApp/rdv-service/(?<segment>.*)","/${segment}")
                                .addRequestHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://RDV-SERVICE"))
                .route(p->p
                        .path("/healthcareApp/consultation-service/**")
                        .filters(f->f.rewritePath("/healthcareApp/consultation-service/(?<segment>.*)","/${segment}")
                                .addRequestHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://CONSULTATION-SERVICE")).build();

    }

}
