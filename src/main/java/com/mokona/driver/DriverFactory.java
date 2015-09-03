package com.mokona.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mokona.properties.MokonaProperties;

public class DriverFactory {

    private static final String CHROME_DRIVER_SYSTEM_PROPERTY = "webdriver.chrome.driver";
    
    public static WebDriver driver;
   
    public static WebDriver get() {
        if (driver == null && MokonaProperties.getChromeDriverPath() != null) {
            System.setProperty(CHROME_DRIVER_SYSTEM_PROPERTY, MokonaProperties.getChromeDriverPath());
            driver = new ChromeDriver();
        }

        return driver;
    }
    
    public void endsDriver() {
        driver.close();
        driver.quit();
    }

}
