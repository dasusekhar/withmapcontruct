package com.example.AngularIntegrationLearnings;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@OpenAPIDefinition
public class AngularIntegrationLearningsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularIntegrationLearningsApplication.class, args);
	}

}
