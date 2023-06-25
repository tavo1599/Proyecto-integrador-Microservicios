package com.quispcs.serviceventa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class ServiceVentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceVentaApplication.class, args);
	}

}
