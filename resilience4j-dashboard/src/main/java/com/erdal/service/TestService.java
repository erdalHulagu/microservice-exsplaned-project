package com.erdal.service;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class TestService {

    @CircuitBreaker(name = "myServiceCircuitBreaker", fallbackMethod = "fallback")
    @Retry(name = "myServiceRetry")
    @RateLimiter(name = "myServiceRateLimiter")
    public String callExternalService() {
        // Normalde burada başka servise istek atacaksın
        throw new RuntimeException("Service failed!"); // test için hep hata fırlat
    }

    public String fallback(Exception ex) {
        return "Fallback response: " + ex.getMessage();
    }
}
