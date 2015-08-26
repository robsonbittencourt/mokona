package com.mokona.element;

import org.openqa.selenium.Keys;

import com.mokona.core.BaseElement;

public class Button extends BaseElement {

    public void click() {
        getElement().sendKeys(Keys.ENTER);
    }

    public String getText() {
        return getElement().getText();
    }

}
