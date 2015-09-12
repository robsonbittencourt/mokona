package com.mokona.core;

import static com.mokona.wait.WaitTool.waitForElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.inject.Inject;
import com.mokona.exception.MokonaException;

public abstract class MokonaElement {
    
    @Inject
    private WebDriver webDriver;

    private WebElement webElement;

    private String selector;
    
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
