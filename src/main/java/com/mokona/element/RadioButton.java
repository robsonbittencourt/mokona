package com.mokona.element;

import com.mokona.core.BaseElement;

public class RadioButton extends BaseElement {

	public void select() {
		getElement().click();
	}

	public boolean isSelected() {
		return getElement().isSelected();
	}

}
