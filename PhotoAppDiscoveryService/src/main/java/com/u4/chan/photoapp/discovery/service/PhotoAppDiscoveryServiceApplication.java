package com.u4.chan.photoapp.discovery.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PhotoAppDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppDiscoveryServiceApplication.class, args);
	}

}
