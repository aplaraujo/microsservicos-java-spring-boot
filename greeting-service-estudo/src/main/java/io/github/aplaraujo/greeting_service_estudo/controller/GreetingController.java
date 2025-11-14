package io.github.aplaraujo.greeting_service_estudo.controller;

import io.github.aplaraujo.greeting_service_estudo.config.GreetingConfiguration;
import io.github.aplaraujo.greeting_service_estudo.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingConfiguration greetingConfiguration;

    @GetMapping(value = "/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
        if (name.isEmpty()) {
            name = greetingConfiguration.getDefaultValue();
        }
        return new Greeting(counter.incrementAndGet(), String.format(template, greetingConfiguration.getGreeting(), name));
    }
}
