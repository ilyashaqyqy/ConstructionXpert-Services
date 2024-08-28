package com.construction.projets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ProjetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetsApplication.class, args);
	}

}
