package com.shady.hidradenitis.suppurativa.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.shady")
@SpringBootApplication
public class HidradenitisSupparativaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HidradenitisSupparativaApplication.class, args);
	}

}
