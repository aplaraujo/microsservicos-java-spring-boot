package io.github.aplaraujo.proxy;

import io.github.aplaraujo.dto.ExchangeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "exchange-service-estudo", url = "localhost:8000") // Aponta que o serviço "Exchange"
public interface ExchangeProxy {
    @GetMapping(value = "/exchange-service/{amount}/{from}/{to}")
    public ExchangeDTO getExchange(
            @PathVariable(name = "amount") BigDecimal amount,
            @PathVariable(name = "from") String from,
            @PathVariable(name = "to") String to);
}
