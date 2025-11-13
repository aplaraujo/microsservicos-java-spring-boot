package io.github.aplaraujo.greeting_service_estudo;

import io.github.aplaraujo.greeting_service_estudo.config.GreetingConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GreetingConfiguration.class)
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
