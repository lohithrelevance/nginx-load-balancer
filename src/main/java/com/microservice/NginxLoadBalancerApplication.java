package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NginxLoadBalancerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NginxLoadBalancerApplication.class, args);
	}

}
