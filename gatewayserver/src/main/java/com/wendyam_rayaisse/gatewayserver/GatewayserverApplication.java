package com.wendyam_rayaisse.gatewayserver;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import reactor.core.publisher.Mono;

import java.time.Duration;
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
                                        .setFallbackUri("forward:/contactSupport") )
                        )
                        .uri("lb://MEDECIN-SERVICE"))
                .route(p->p
                        .path("/healthcareApp/patient-service/**")
                        .filters(f->f.rewritePath("/healthcareApp/patient-service/(?<segment>.*)","/${segment}")
                                .addRequestHeader("X-Response-Time", LocalDateTime.now().toString())
                                .retry(retryConfig -> retryConfig.setRetries(3).setMethods(HttpMethod.GET)
                                        .setBackoff(
                                                Duration.ofMillis(100),Duration.ofMillis(1000),2,true
                                        )))
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
                        .path("/healthcareApp/constante-service/**")
                        .filters(f->f.rewritePath("/healthcareApp/constante-service/(?<segment>.*)","/${segment}")
                                .addRequestHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://CONSTANTE-SERVICE"))

                .route(p->p
                        .path("/healthcareApp/consultation-service/**")
                        .filters(f->f.rewritePath("/healthcareApp/consultation-service/(?<segment>.*)","/${segment}")
                                .addRequestHeader("X-Response-Time", LocalDateTime.now().toString())
                                .requestRateLimiter(config->config.setRateLimiter(redisRateLimiter()).setKeyResolver(userKeyResolver()))
                        )
                        .uri("lb://CONSULTATION-SERVICE")).build();

    }

    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
                .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
                .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(30)).build()).build());
    }

    @Bean
    public RedisRateLimiter redisRateLimiter(){
        return new RedisRateLimiter(1,1,1);
    }


    @Bean
    KeyResolver userKeyResolver(){
        return exchange-> Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst("user")).defaultIfEmpty("anonymous");
    }

}
