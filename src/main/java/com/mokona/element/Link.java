package com.mokona.element;

import com.mokona.core.MokonaElement;

public class Link extends MokonaElement {

    public String getText() {
        return getWebElement().getText();
    }

    public void click() {
        getWebElement().click();
    }

}
