package ru.boxberry.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import ru.boxberry.helpers.Attach;
import ru.boxberry.properties.SystemProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.browser = SystemProperties.browser();
        Configuration.browserVersion = SystemProperties.browserVersion();
        Configuration.browserSize = SystemProperties.browserSize();
        //Configuration.remote="https://user1:1234@selenoid.autotests.cloud/wd/hub";
        //if (System.getProperty("remoteURL") != null) {
        System.out.println(System.getProperty("remoteURL"));
            Configuration.remote = SystemProperties.remoteUrl();
       // }
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
