package org.springmicro.currencyconversion.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springmicro.currencyconversion.entity.CurrencyConversion;

//@FeignClient(name = "currency-exchange",url = "localhost:8000")
@FeignClient(name = "CURRENCY-EXCHANGE") // loadbalancer comes by default with eureka-client and starter-config client side load balancing
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion currencyExchangeValue(@PathVariable String from,
                                                    @PathVariable String to);
}
