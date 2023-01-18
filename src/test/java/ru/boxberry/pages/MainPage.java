package ru.boxberry.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public SelenideElement
            catalogNav = $("a[text()='Доставка ']"),
            titleNavItem = $("h1[text()='Доставка посылок по России']");

    public MainPage chooseNavItem(String value) {
        catalogNav.hover();
        $("a[text()='" + value + "']").click();
        return this;
    }

    public MainPage checkNavItem(String value) {
        titleNavItem.shouldHave(text(value));
        return this;
    }

    public MainPage chooseMenuList(String value) {
        $x("//div[@class='header__items']//a[text()='Бизнес-партнерам']").click();
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
}
