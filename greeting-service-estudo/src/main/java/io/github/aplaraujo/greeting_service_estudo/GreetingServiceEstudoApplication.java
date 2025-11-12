package io.github.aplaraujo.greeting_service_estudo;

import io.github.aplaraujo.greeting_service_estudo.config.GreetingConfiguration;
import io.github.aplaraujo.greeting_service_estudo.controller.GreetingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GreetingConfiguration.class)
public class GreetingServiceEstudoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingServiceEstudoApplication.class, args);
	}

}
