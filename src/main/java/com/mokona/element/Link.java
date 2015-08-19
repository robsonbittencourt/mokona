package com.mokona.element;

import com.mokona.core.BaseElement;

public class Link extends BaseElement {

	public String getText() {
		return getElement().getText();
	}

	public void click() {
		getElement().click();
	}

}
