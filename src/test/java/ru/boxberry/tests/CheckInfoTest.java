package ru.boxberry.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.boxberry.pages.MainPage;

import static io.qameta.allure.Allure.step;

public class CheckInfoTest {
    MainPage mainPage = new MainPage();

    @Tag("Web")
    @Test
    @DisplayName("Проверка контактов в Екатеринбурге")
    void checkContactTest() {

        step("Открыть выбор городов", () -> {
            mainPage.openSearchCity("Екатеринбург");
        });

        step("Перейти в раздел Контакты", () ->
                mainPage.goContact());

        step("Проверить номер для частных клиентов", () ->
                mainPage.checkPhone("8-800-234-80-00"));
    }

    @Tag("Web")
    @ParameterizedTest(name = "Поиск по сайту {0}")
    @ValueSource(strings = {"Доставка","Посылка"})
    void costCalcTest(String word) {

        step("Ввод текста поиска", () ->
                mainPage.searchInput(word)
        );

        step("Проверка результата поиска", () ->
                mainPage.resultSearch(word)
        );
    }
}
