package com.example.creadible;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableBatchProcessing
@EnableJpaAuditing
@SpringBootApplication
public class CreadibleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreadibleApplication.class, args);
	}

}
