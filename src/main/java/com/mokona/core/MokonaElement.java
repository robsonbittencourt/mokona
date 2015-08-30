package com.mokona.core;

import static com.mokona.wait.WaitTool.waitForElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mokona.driver.Driver;
import com.mokona.exception.MokonaException;

public abstract class MokonaElement {

    private WebElement element;

    private WebDriver driver;

    private String selector;

    public MokonaElement() {
        driver = Driver.getDriver();
    }

    protected WebDriver getWebDriver() {
        return driver;
    }

    protected WebElement getElement() {
        if (element != null) {
            return element;
        }

        return findElement();
    }

    private WebElement findElement() {
        try {
            element = driver.findElement(By.cssSelector(selector));
            waitForElement(driver, By.cssSelector(selector), 30);
        } catch (NoSuchElementException e) {
            throw new MokonaException("Element not found on the page.");
        }

        return element;
    }

}
