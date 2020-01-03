package com.exemple.selenide.implementation;

import com.exemple.selenide.kotlin.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static com.exemple.selenide.kotlin.CarKt.topLevel;

@Component
public class Centrale {

    private static final Logger log = LoggerFactory.getLogger(Centrale.class);

    public void aff() {
        log.debug(String.format("Bonjour, je suis la classe centrale.") );

        topLevel();

//        Car car = new Car("mercedes", "noir", 2017);
//        car.qui();
    }

}
