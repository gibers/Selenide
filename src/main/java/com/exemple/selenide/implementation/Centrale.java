package com.exemple.selenide.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Centrale {

    private static final Logger log = LoggerFactory.getLogger(Centrale.class);

    public void aff() {
        log.debug(String.format("Bonjour, je suis la classe centrale.") );
    }

}
