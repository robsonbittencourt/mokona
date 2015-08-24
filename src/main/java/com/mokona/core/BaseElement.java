package com.mokona.core;

import static com.mokona.wait.WaitTool.waitForElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mokona.driver.Driver;

public abstract class BaseElement {

	private WebElement element;

	private WebDriver driver;

	private String selector;

	public BaseElement() {
		driver = Driver.getDriver();
	}
	
	protected WebDriver getWebDriver() {
		return driver;
	}

	protected WebElement getElement() {
		if (element != null) {
			return element;
		}

		try {
			element = findElement();
		} catch (Exception e) {
			System.out.println("Could not find the element in the class.");
		}

		return element;
	}

	private WebElement findElement() {
		try {
			element = driver.findElement(By.cssSelector(selector));
			waitForElement(driver, By.cssSelector(selector), 30);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found on the page.");
		}

		return element;
	}

}
