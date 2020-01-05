package com.exemple.selenide;

import com.exemple.selenide.implementation.Centrale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SelenideApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SelenideApplication.class);

    @Autowired
    private ApplicationContext ctx;

    public static void main(String[] args) {
        SpringApplication.run(SelenideApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Centrale centrale = ctx.getBean(Centrale.class);
        centrale.calculJava();
    }
}
