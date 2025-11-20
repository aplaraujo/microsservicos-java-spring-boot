package io.github.aplaraujo.controller;

import io.github.aplaraujo.environment.InstanceInformationService;
import io.github.aplaraujo.model.HelloDocker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

    private final InstanceInformationService informationService;

    Logger logger = LoggerFactory.getLogger(DockerController.class);

    public DockerController(InstanceInformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping(path = "/")
    public String imUpAndRunning() {
        return "{healthy:true}";
    }

    @RequestMapping("/hello-docker")
    public HelloDocker greeting() {
        logger.info("Endpoint /hello-docker is called!!!");

        return new HelloDocker("Hello Docker V1", informationService.retrieveInstanceInfo());
    }
}
