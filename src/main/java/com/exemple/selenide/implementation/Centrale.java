package com.exemple.selenide.implementation;

import com.exemple.selenide.kotlin.Car;
import com.exemple.selenide.kotlin.SingletonObj;
import com.exemple.selenide.kotlin.StaticCar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.exemple.selenide.kotlin.EnsembleKt.calculEqu2;
import static com.exemple.selenide.kotlin.EnsembleKt.calculListDiviseurQ;
import static com.exemple.selenide.kotlin.StaticCar.topLevel;


@Component
public class Centrale {

    private static final Logger log = LoggerFactory.getLogger(Centrale.class);

    public void calculJava() {
        calculEqu2();
        calculListDiviseurQ();
    }

    public void aff() {
        log.debug(String.format("Bonjour, je suis la classe centrale.") );
        topLevel();

        StaticCar.print("toto");

        Car car = new Car("mercedes", "noir", 2017);
//        car.setColor("bb");
//        car.setMotor("fff");
        System.out.println(" est de couleur : " + car.color);
//        car.qui();

        Car.carComp();

        SingletonObj.INSTANCE.doSomething();

        System.out.println("adresse memoire : " + Car.Companion.isAuto());

        car.printMe(null);

        try {
            car.doIo();
        } catch (IOException e) {

        }

    }

}
