package com.mokona.element;


public class Link extends BaseElement {

	public String getText() {
		return getElement().getText();
	}

	public void click() {
		getElement().click();
	}

}
