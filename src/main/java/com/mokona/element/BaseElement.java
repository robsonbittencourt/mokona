package com.mokona.element;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mokona.drive.Driver;

public abstract class BaseElement {

	private WebElement element;

	protected WebDriver driver;

	private String selector;

	public BaseElement() {
		driver = Driver.getDriver();
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
		waitingElement();

		try {
			element = driver.findElement(By.cssSelector(selector));
		} catch (NoSuchElementException e) {
			System.out.println("Element not found on the page.");
		}

		return element;
	}

	private void waitingElement() {
		// implement waiting
	}

}
