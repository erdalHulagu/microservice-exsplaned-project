package com.erdal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Resilience4jDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(Resilience4jDashboardApplication.class, args);
	}

}
