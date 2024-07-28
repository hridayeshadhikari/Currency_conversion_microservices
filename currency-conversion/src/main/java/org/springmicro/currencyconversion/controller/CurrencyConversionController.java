package org.springmicro.currencyconversion.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springmicro.currencyconversion.entity.CurrencyConversion;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy proxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertedCurrency(@PathVariable String from,
                                                @PathVariable String to,
                                                @PathVariable BigDecimal quantity){

        HashMap<String,String> uriVariable=new HashMap<>();
        uriVariable.put("from",from);
        uriVariable.put("to",to);
        //restTemplate
        ResponseEntity<CurrencyConversion> responseEntity=new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class,uriVariable);
        CurrencyConversion currencyConversion=responseEntity.getBody();

        return new CurrencyConversion(currencyConversion.getId(), from,to,quantity,
                currencyConversion.getConversionRate(),
                quantity.multiply(currencyConversion.getConversionRate()),
                currencyConversion.getEnvironment());
    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertedCurrencyFeign(@PathVariable String from,
                                                @PathVariable String to,
                                                @PathVariable BigDecimal quantity){


        CurrencyConversion currencyConversion=proxy.currencyExchangeValue(from,to);
        return new CurrencyConversion(currencyConversion.getId(), from,to,quantity,
                currencyConversion.getConversionRate(),
                quantity.multiply(currencyConversion.getConversionRate()),
                currencyConversion.getEnvironment());
    }
}
