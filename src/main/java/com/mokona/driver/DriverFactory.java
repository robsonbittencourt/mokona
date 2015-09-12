package com.mokona.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mokona.properties.MokonaProperties;

@Singleton
public class DriverFactory {

    private static final String CHROME_DRIVER_SYSTEM_PROPERTY = "webdriver.chrome.driver";
    
    @Inject
    private MokonaProperties mokonaProperties;
    
    public WebDriver driver;
    
    public WebDriver get() {
        if (driver == null && mokonaProperties.getChromeDriverPath() != null) {
            System.setProperty(CHROME_DRIVER_SYSTEM_PROPERTY, mokonaProperties.getChromeDriverPath());
            driver = new ChromeDriver();
        }

        return driver;
    }
    
    public void endsDriver() {
        driver.close();
        driver.quit();
    }

}
