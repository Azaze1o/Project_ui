package ru.boxberry.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

import ru.boxberry.pages.MainPage;

public class MainTests extends TestBase {

    MainPage mainPage = new MainPage();
    TestData data = new TestData();

    @Tag("Web")
    @Test
    @DisplayName("Проверка контактов в Екатеринбурге")
    void checkContactTest() {
        step("Открыть 'https://boxberry.ru/'", () ->
                open("https://boxberry.ru/"));

        step("Открыть выбор городов", () -> {
            $(".town__link").click();
            $x("//input").setValue("Екатеринбург");
            $(".town-popup__item-city").click();
        });

        step("Перейти в раздел Контакты", () ->
                $(".tabs__items").$(byText("Контакты")).click());

        step("Проверить номер для частных клиентов", () ->
                $(".cc-phone").shouldHave(text("8-800-234-80-00")));
    }

    @Tag("Web")
    @Test
    @DisplayName("Проверка отслеживания посылки")
    void checkTrackBoxTest() {
        step("Открыть 'https://boxberry.ru/'", () ->
                open("https://boxberry.ru/"));

        step("Открыть раздел отслеживания посылок'", () -> {
            $(byText("Доставка")).hover();
            $(byText("Отследить посылку")).click();
        });

        step("Проверить раздел на который попали", () -> {
            $(".pageTitle__title").shouldHave(text("Отследить посылку"));
        });
    }

    @Tag("Web")
    @Test
    @DisplayName("Выбор города")
    void chooseCityTest() {
        step("Открыть 'https://boxberry.ru/'", () ->
                open("https://boxberry.ru/"));

        step("Город должен отображаться", () -> {
            $(".town__link").shouldBe(visible);
        });

        step("Открыть выбор городов", () -> {
            $(".town__link").click();
            $x("//label[@class='town-popup__label']/span").shouldHave(text("Выберите ваш город"));
            $(".field-input__inner").shouldHave(type("text"));
        });
    }

    @Tag("Web")
    @Test
    @DisplayName("Проверка главной страницы")
    void checkTitleTest() {
        step("Открыть главную страницу 'https://boxberry.ru/'", () ->
                open("https://boxberry.ru/"));

        step("Страница называется 'Boxberry - служба доставки для интернет-магазинов и частных лиц.'", () -> {
            String expectedTitle = "Boxberry – служба доставки для интернет-магазинов и частных лиц.";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Tag("Web")
    @Test
    @DisplayName("Открытие вкладки во всплывающем меню")
    void navMenuTest() {
        step("Открыть 'https://boxberry.ru/'", () ->
                open("https://boxberry.ru/"));

        step("Выбираем вкладку в навигационном меню", () ->
                mainPage.chooseNavItem(data.titleNavItem));
        step("Проверяем результат открытия вкладки", () ->
                mainPage.checkNavItem(data.titleResultNavItem));
    }

    @Tag("Web")
    @Test
    @DisplayName("Открытие вкладок на главной странице")
    void stableMenuTest() {
        step("Открыть 'https://boxberry.ru/'", () ->
                open("https://boxberry.ru/"));

        step("Выбираем вкладку на главной странице", () ->
                mainPage.chooseMenuList(data.titleMenuItem)
        );

        step("Проверяем результат открытой вкладки", () ->
                mainPage.checkMenuList()
        );
    }

    @Tag("Web")
    @Test
    @DisplayName("Поиск по сайту")
    void costCalcTest() {
        step("Открыть 'https://boxberry.ru/'", () ->
                open("https://boxberry.ru/"));

        step("Ввод текста поиска", () ->
                mainPage.searchInput(data.searchText)
        );

        step("Проверка результата поиска", () ->
            mainPage.resultSearch(data.searchText)
        );
    }

}
