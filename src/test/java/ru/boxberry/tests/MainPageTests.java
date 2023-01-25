package ru.boxberry.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPageTests extends TestBase {

    @Tag("Web")
    @Test
    @DisplayName("Проверка главной страницы")
    void checkTitleTest() {

        step("Страница называется 'Boxberry - служба доставки для интернет-магазинов и частных лиц.'", () -> {
            String expectedTitle = "Boxberry – служба доставки для интернет-магазинов и частных лиц.";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }
}
