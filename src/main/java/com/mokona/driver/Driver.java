package com.mokona.driver;

import org.openqa.selenium.WebDriver;

public abstract class Driver {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = DriverFactory.get();
        }

        return driver;
    }

    public void endsDriver() {
        driver.close();
        driver.quit();
    }

}
