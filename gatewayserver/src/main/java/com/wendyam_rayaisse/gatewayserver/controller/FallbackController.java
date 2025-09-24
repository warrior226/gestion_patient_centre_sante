package com.wendyam_rayaisse.gatewayserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Fallback Controller to handle circuit breaker fallback scenarios.
 * 
 * This controller provides a fallback response when a circuit is open or when
 * a service is unavailable. It's used in conjunction with Spring Cloud Gateway's
 * circuit breaker to provide a graceful degradation of service.
 * 
 * The endpoint returns a user-friendly error message with support contact information
 * when a service call fails and the circuit is open.
 */
@RestController
public class FallbackController {

    /**
     * Fallback endpoint that returns a user-friendly error message.
     * This is called when a service is unavailable and the circuit is open.
     * 
     * @return A Mono containing the error message with support contact information
     */
    @RequestMapping("/contactSupport")
    public Mono<String> contactSupport() {
        return Mono.just("An error occurred. Please try again after some time or contact developer support: rayaisse.wendyam@gmail.com");
    }
}
