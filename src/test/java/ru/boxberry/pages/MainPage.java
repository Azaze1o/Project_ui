package ru.boxberry.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public SelenideElement
            titleNavItem = $("h1");

    public MainPage chooseNavItem(String value) {
        $(byText("Доставка")).hover();
        $(byText(value)).click();
        return this;
    }

    public MainPage checkNavItem(String value) {
        titleNavItem.shouldHave(text(value));
        return this;
    }

    public MainPage chooseMenuList(String value) {
        $(byText("Бизнес-партнерам")).click();
        return this;
    }

    public MainPage checkMenuList() {
        $x("//a[@href='/biznes-partneram/open-terminal']").shouldHave(text(" Открыть терминал "));
        return this;
    }

    public MainPage searchInput(String text) {
        $("input.header-search__input").setValue(text).sendKeys(Keys.ENTER);
        return this;
    }

    public MainPage resultSearch(String text){
        $("h1.pageTitle__title").shouldHave(text("Результаты поиска «"+text+"»"));
        return this;
    }

    public MainPage openSearchCity(String city){
        $(".town__link").click();
        $x("//input").setValue(city);
        $(".town-popup__item-city").click();
        return this;
    }

    public MainPage goContact(){
        $(".tabs__items").$(byText("Контакты")).click();
        return this;
    }

    public MainPage checkPhone(String phone){
        $(".cc-phone").shouldHave(text(phone));
        return this;
    }

    public MainPage openTrackingPage(){
        $(byText("Доставка")).hover();
        $(byText("Отследить посылку")).click();
        return this;
    }

    public MainPage checkTrackingPage(){
        $(".pageTitle__title").shouldHave(text("Отследить посылку"));
        return this;
    }

    public MainPage checkVisionCity(){
        $(".town__link").shouldBe(visible);
        return this;
    }

    public MainPage openChooseCity(){
        $(".town__link").click();
        $x("//label[@class='town-popup__label']/span").shouldHave(text("Выберите ваш город"));
        $(".field-input__inner").shouldHave(type("text"));
        return this;
    }
}
