package com.mokona.element;


public class RadioButton extends BaseElement {

	public void select() {
		getElement().click();
	}

	public boolean isSelected() {
		return getElement().isSelected();
	}

}
