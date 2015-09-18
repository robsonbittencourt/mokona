package com.mokona.core;

import javax.inject.Inject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mokona.exception.MokonaException;
import com.mokona.wait.WaitTool;

public abstract class MokonaElement {

	@Inject
	private WebDriver webDriver;

	@Inject
	private WaitTool waitTool;

	private WebElement webElement;

	private String selector;

	protected WebDriver getWebDriver() {
		return webDriver;
	}

	protected WebElement getWebElement() {
		if (webElement == null) {
			webElement = findElement();
		}

		return webElement;
	}

	private WebElement findElement() {
		try {
			WebElement element = webDriver.findElement(By.cssSelector(selector));
			waitTool.waitForElement(By.cssSelector(selector), 30);
			return element;
		} catch (NoSuchElementException e) {
			throw new MokonaException("Element not found on the page.", e);
		}
	}

}
