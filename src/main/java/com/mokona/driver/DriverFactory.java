package com.mokona.driver;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mokona.core.PropertiesReader;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver get() {
        Map<String, String> properties = PropertiesReader.get();
        String driverType = null;
        String driverPath = null;

        for(Entry<String, String> entry : properties.entrySet()) {
            if(entry.getKey().startsWith("mokona.webdriver")) {
                driverType = entry.getKey();
                driverPath = entry.getValue();
                break;
            }
        }

        if (driverType.equals("mokona.webdriver.chrome")) {
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
        }

        return driver;

    }

}
