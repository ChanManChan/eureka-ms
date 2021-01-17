package com.u4.api.accountmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AccountmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountmanagementApplication.class, args);
	}

}
