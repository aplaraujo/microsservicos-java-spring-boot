package io.github.aplaraujo.controller;

import io.github.aplaraujo.environment.InstanceInformationService;
import io.github.aplaraujo.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/book-service")
@RequiredArgsConstructor
public class BookController {
    // http://localhost:8100/book-service/1/BRL

    private final InstanceInformationService informationService;

    @GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {
        String port = informationService.retrieveServerPort();
        return new Book(
                1L,
                "Nigel Poulton",
                new Date(),
                15.8,
                "Docker Deep Dive",
                "BRL",
                port
        );
    }
}
