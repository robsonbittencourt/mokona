package com.mokona.element;

import org.openqa.selenium.Keys;

import com.mokona.core.MokonaElement;

public class Button extends MokonaElement {

    public void click() {
        getWebElement().sendKeys(Keys.ENTER);
    }

    public String getText() {
        return getWebElement().getText();
    }

}
