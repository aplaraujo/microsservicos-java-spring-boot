package io.github.aplaraujo.controller;

import io.github.aplaraujo.environment.InstanceInformationService;
import io.github.aplaraujo.model.Exchange;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/exchange-service")
@RequiredArgsConstructor
public class ExchangeController {
    // http://localhost:8000/exchange-service/5/USD/BRL

    private final InstanceInformationService informationService;

    @GetMapping(value = "/{amount}/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Exchange getExchange(
            @PathVariable(name = "amount") BigDecimal amount,
            @PathVariable(name = "from") String from,
            @PathVariable(name = "to") String to) {
        return new Exchange(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, "PORT " + informationService.retrieveServerPort());
    }
}
