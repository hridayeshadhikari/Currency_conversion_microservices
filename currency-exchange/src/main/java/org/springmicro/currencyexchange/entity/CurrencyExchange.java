package org.springmicro.currencyexchange.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class CurrencyExchange {

    @Id
    private long id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "Currency_to")
    private String to;
    private BigDecimal conversionRate;
    private String environment;
    public CurrencyExchange(long id, String from, String to, BigDecimal conversionRate) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionRate = conversionRate;
    }

    public CurrencyExchange() {

    }
}
