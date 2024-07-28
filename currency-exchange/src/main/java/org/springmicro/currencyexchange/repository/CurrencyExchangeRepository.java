package org.springmicro.currencyexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springmicro.currencyexchange.entity.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository< CurrencyExchange,Long> {

    CurrencyExchange findByFromAndTo(String from,String to);
}
