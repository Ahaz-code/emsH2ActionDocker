package com.example.emsH2ActionDocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmsH2ActionDockerApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(EmsH2ActionDockerApplication.class);
		app.setAdditionalProfiles("h2"); // or "mysql"
		app.run(args);
	}

}
