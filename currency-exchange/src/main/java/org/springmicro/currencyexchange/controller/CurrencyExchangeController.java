package org.springmicro.currencyexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springmicro.currencyexchange.entity.CurrencyExchange;
import org.springmicro.currencyexchange.repository.CurrencyExchangeRepository;




@RestController
public class CurrencyExchangeController {


    @Autowired
    private CurrencyExchangeRepository currencyRepository;
    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange currencyExchangeValue(@PathVariable String from, @PathVariable String to) {
//        CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
        CurrencyExchange currencyExchange=currencyRepository.findByFromAndTo(from,to);
        if(currencyExchange==null){
            throw new RuntimeException("currency exchange not found");
        }
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
