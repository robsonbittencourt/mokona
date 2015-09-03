package com.mokona.core;

import static com.mokona.wait.WaitTool.waitForElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mokona.driver.DriverFactory;
import com.mokona.exception.MokonaException;

public abstract class MokonaElement {

    private WebElement webElement;

    private WebDriver webDriver;

    private String selector;

    public MokonaElement() {
        webDriver = DriverFactory.get();
    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }

    protected WebElement getWebElement() {
        if (webElement != null) {
            return webElement;
        }

        return findElement();
    }

    private WebElement findElement() {
        try {
            webElement = webDriver.findElement(By.cssSelector(selector));
            waitForElement(webDriver, By.cssSelector(selector), 30);
        } catch (NoSuchElementException e) {
            throw new MokonaException("Element not found on the page.");
        }

        return webElement;
    }

}
