package org.springmicro.currencyexchange.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger= LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/currency-exchange/sample-api")
//    @Retry(name = "sample-api",fallbackMethod = "hardCodedResponse")
    @CircuitBreaker(name = "default",fallbackMethod = "hardCodedResponse")
    public String sampleApi(){
        logger.info("sample api response");
        ResponseEntity<String> forEntity=new RestTemplate().getForEntity("http://localhost/sample",String.class);
        return forEntity.getBody();
    }

    public String hardCodedResponse(Exception e){
        return "fallback response";
    }

}
