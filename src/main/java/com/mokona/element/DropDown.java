package com.mokona.element;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown extends BaseElement {

	public void select(String item) {
		WebElement element = getElement();
		WebDriverWait espera = new WebDriverWait(driver, 20, 100);
		espera.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		element.sendKeys(item);

		element.sendKeys(Keys.ENTER);
		element.sendKeys(Keys.TAB);
	}

}
