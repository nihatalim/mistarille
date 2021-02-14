package dev.mistarille.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"dev.mistarille.domain", "dev.mistarille.infrastructure"})
public class InfrastructureApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfrastructureApplication.class, args);
	}

}
