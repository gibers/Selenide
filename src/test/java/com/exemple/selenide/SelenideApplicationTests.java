package com.exemple.selenide;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.springframework.boot.test.context.SpringBootTest;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@SpringBootTest
class SelenideApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void userCanLoginByUsername() throws InterruptedException {
        open("https://www.youtube.com/watch?v=2UtK43rh5GE");


        $(By.name("button")).should(exist).click();

        Thread.sleep(10000);

//        $("#submit").click();
//        $(".loading_progress").should(disappear); // Waits until element disappears
//        $("#username").shouldHave(text("Hello, Johny!")); // Waits until element gets text
    }

}
