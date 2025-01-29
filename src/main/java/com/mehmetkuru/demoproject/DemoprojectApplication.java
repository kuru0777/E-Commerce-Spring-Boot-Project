package com.mehmetkuru.demoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.mehmetkuru")
@EntityScan("com.mehmetkuru.model")
@EnableJpaRepositories("com.mehmetkuru.repository")
public class DemoprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoprojectApplication.class, args);
		System.out.print("mehmet");
	}

}
