package ru.boxberry.properties;

import org.aeonbits.owner.ConfigFactory;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverProvider {
    static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void configure() {

        Configuration.browserSize = WebDriverProvider.config.browserSize();
        Configuration.browser = WebDriverProvider.config.browser();
        Configuration.browserVersion = WebDriverProvider.config.browserVersion();

        String remoteUrl = WebDriverProvider.config.remote();
        if (remoteUrl != null) {
            Configuration.remote = remoteUrl;
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }




    }
}
