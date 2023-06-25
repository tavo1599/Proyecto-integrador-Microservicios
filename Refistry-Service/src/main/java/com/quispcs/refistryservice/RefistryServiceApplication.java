package com.quispcs.refistryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RefistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RefistryServiceApplication.class, args);
	}

}
