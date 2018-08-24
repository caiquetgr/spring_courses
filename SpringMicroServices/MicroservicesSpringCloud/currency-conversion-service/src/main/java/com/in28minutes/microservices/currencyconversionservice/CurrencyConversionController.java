package com.in28minutes.microservices.currencyconversionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {

        CurrencyConversionBean response = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);

        logger.info("{}", response);

        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(),
                quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());

    }
}
