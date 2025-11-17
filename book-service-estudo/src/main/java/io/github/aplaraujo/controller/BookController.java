package io.github.aplaraujo.controller;

import io.github.aplaraujo.dto.ExchangeDTO;
import io.github.aplaraujo.environment.InstanceInformationService;
import io.github.aplaraujo.model.Book;
import io.github.aplaraujo.proxy.ExchangeProxy;
import io.github.aplaraujo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/book-service")
@RequiredArgsConstructor
public class BookController {
    // http://localhost:8100/book-service/1/BRL

    private final InstanceInformationService informationService;
    private final BookRepository bookRepository;
    private final ExchangeProxy exchangeProxy;

    @GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {
        String port = informationService.retrieveServerPort();
        var book = bookRepository.findById(id).orElseThrow();
        ExchangeDTO dto = exchangeProxy.getExchange(BigDecimal.valueOf(book.getPrice()), "USD", currency);

        // book.setEnvironment(port + " FEIGN");
        book.setEnvironment("BOOK PORT: " + port + " EXCHANGE PORT: " + dto.getEnvironment());
        assert dto != null;
        book.setPrice(dto.getConvertedValue().doubleValue());
        book.setCurrency(currency);

        return book;
    }

    // Terceira implementação
//    @GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Book findBook(
//            @PathVariable("id") Long id,
//            @PathVariable("currency") String currency
//    ) {
//
//        var book = bookRepository.findById(id).orElseThrow();
//        String port = informationService.retrieveServerPort();
//
//        // Parâmetros que serão enviados para o serviço
//        HashMap<String, String> params = new HashMap<>();
//        params.put("amount", book.getPrice().toString());
//        params.put("from", "USD");
//        params.put("to", currency);
//
//        var response = new RestTemplate().getForEntity("http://localhost:8000/exchange-service/{amount}/{from}/{to}", ExchangeDTO.class, params);
//
//        ExchangeDTO dto = response.getBody();
//
//        book.setEnvironment(port);
//        assert dto != null;
//        book.setPrice(dto.getConvertedValue().doubleValue());
//        book.setCurrency(currency);
//
//        return book;
//    }


// Segunda implementação
//    @GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Book findBook(
//            @PathVariable("id") Long id,
//            @PathVariable("currency") String currency
//    ) {
//
//        var book = bookRepository.findById(id).orElseThrow();
//        String port = informationService.retrieveServerPort();
//        book.setEnvironment(port);
//        book.setCurrency(currency);
//        return book;
//    }

    // Primeira implementação
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
