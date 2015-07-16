package com.mokona.element;

import org.openqa.selenium.Keys;

public class Button extends BaseElement {

	public void click() {
		getElement().sendKeys(Keys.ENTER);
	}

	public String getText() {
		return getElement().getText();
	}

}
