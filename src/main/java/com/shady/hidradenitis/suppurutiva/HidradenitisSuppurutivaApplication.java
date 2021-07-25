package com.shady.hidradenitis.suppurutiva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.shady")
@SpringBootApplication
@EnableJpaRepositories("com.shady")
@EntityScan("com.shady")
public class HidradenitisSuppurutivaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HidradenitisSuppurutivaApplication.class, args);
	}

}
