package com.erdal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @GetMapping("/orderFallBack")
    public Mono<String> orderServiceFallBack() {
        return Mono.just("Order service is taking too long or is down. Please try again later.");
    }

    @GetMapping("/paymentFallBack")
    public Mono<String> paymentFallBack() {
        return Mono.just("Payment service is taking too long or is down. Please try again later.");
    }
}
