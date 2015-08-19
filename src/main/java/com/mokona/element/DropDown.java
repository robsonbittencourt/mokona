package com.mokona.element;

import org.openqa.selenium.Keys;

import com.mokona.core.BaseElement;

public class DropDown extends BaseElement {

	public void select(String item) {
		getElement().click();
		getElement().sendKeys(item);

		getElement().sendKeys(Keys.ENTER);
	}

}
