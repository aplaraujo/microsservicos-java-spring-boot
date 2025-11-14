package io.github.aplaraujo.controller;

import io.github.aplaraujo.environment.InstanceInformationService;
import io.github.aplaraujo.model.Book;
import io.github.aplaraujo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book-service")
@RequiredArgsConstructor
public class BookController {
    // http://localhost:8100/book-service/1/BRL

    private final InstanceInformationService informationService;
    private final BookRepository bookRepository;

    @GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {

        var book = bookRepository.findById(id).orElseThrow();
        String port = informationService.retrieveServerPort();
        book.setEnvironment(port);
        book.setCurrency(currency);
        return book;
    }
//    @GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Book findBook(
//            @PathVariable("id") Long id,
//            @PathVariable("currency") String currency
//    ) {
//        String port = informationService.retrieveServerPort();
//        return new Book(
//                1L,
//                "Nigel Poulton",
//                new Date(),
//                15.8,
//                "Docker Deep Dive",
//                "BRL",
//                port
//        );
//    }
}
