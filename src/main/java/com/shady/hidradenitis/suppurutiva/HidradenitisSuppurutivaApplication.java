package com.shady.hidradenitis.suppurutiva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@ComponentScan(basePackages = "com.shady")
@SpringBootApplication
@EnableJpaRepositories("com.shady")
@EntityScan("com.shady")
public class HidradenitisSuppurutivaApplication {
	@Autowired
	private Environment env;

	@Value("${spring-maven-custom-property}")
	private String springMavenCustomProperty;

	public static void main(String[] args) {
		SpringApplication.run(HidradenitisSuppurutivaApplication.class, args);
	}

	@PostConstruct
	private void logBuildProperties() {
		System.out.println("maven-property: " + env.getProperty("custom-property"));
		System.out.println("spring property: " + env.getProperty("spring-property"));
		System.out.println("spring-maven-property: " + env.getProperty("spring-maven-property"));
		System.out.println("spring-maven-custom-property: " + env.getProperty("spring-maven-custom-property"));
		System.out.println("spring-maven-custom-property: " + springMavenCustomProperty);
		System.out.println("property-from-cmd: " + env.getProperty("property-from-cmd"));
	}
}
