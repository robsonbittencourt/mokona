package com.mokona.element;

import com.mokona.core.MokonaElement;

public class TextField extends MokonaElement {

    public void set(String text) {
        getWebElement().sendKeys(text);
    }

    public void set(int text) {
        set(Integer.toString(text));
    }

    public boolean isFilled() {
        return get() != null;
    }

    public String get() {
        return getWebElement().getText();
    }

    public void clear() {
        getWebElement().clear();
    }

}
