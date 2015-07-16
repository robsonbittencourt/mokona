package com.mokona.element;



public class TextField extends BaseElement {

	public void set(String text) {
		getElement().sendKeys(text);
	}

	public void set(int text) {
		set(Integer.toString(text));
	}

	public boolean isFilled() {
		return get() != null;
	}

	public String get() {
		return getElement().getText();
	}

	public void clear() {
		getElement().clear();
	}

}
