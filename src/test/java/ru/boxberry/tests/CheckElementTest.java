package ru.boxberry.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.boxberry.pages.MainPage;

import static io.qameta.allure.Allure.step;

public class CheckElementTest extends TestBase {
    MainPage mainPage = new MainPage();
    TestData data = new TestData();

    @Tag("Web")
    @Test
    @DisplayName("Проверка отслеживания посылки")
    void checkTrackBoxTest() {

        step("Открыть раздел отслеживания посылок'", () -> {
            mainPage.openTrackingPage();
        });

        step("Проверить раздел на который попали", () -> {
            mainPage.checkTrackingPage();
        });
    }

    @Tag("Web")
    @Test
    @DisplayName("Открытие вкладки во всплывающем меню")
    void navMenuTest() {

        step("Выбираем вкладку в навигационном меню", () ->
                mainPage.chooseNavItem(data.titleNavItem));
        step("Проверяем результат открытия вкладки", () ->
                mainPage.checkNavItem(data.titleResultNavItem));
    }

    @Tag("Web")
    @Test
    @DisplayName("Открытие вкладок на главной странице")
    void stableMenuTest() {

        step("Выбираем вкладку на главной странице", () ->
                mainPage.chooseMenuList(data.titleMenuItem)
        );

        step("Проверяем результат открытой вкладки", () ->
                mainPage.checkMenuList()
        );
    }

    @Tag("Web")
    @Test
    @DisplayName("Выбор города")
    void chooseCityTest() {

        step("Город должен отображаться", () -> {
            mainPage.checkVisionCity();
        });

        step("Открыть выбор городов", () -> {
            mainPage.openChooseCity();
        });
    }
}
