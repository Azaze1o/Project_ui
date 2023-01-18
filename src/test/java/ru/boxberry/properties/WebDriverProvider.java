package ru.boxberry.properties;

import org.aeonbits.owner.ConfigFactory;
import com.codeborne.selenide.Configuration;

public class WebDriverProvider {
    static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void configure() {

        Configuration.baseUrl = WebDriverProvider.config.browserSize();
        Configuration.browser = WebDriverProvider.config.browser();
        Configuration.browserVersion = WebDriverProvider.config.browserVersion();

        String remoteUrl = WebDriverProvider.config.remote();
        if (remoteUrl != null) {
            Configuration.remote = remoteUrl;
        }


    }
}
