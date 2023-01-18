package ru.boxberry.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
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
}
