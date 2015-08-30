package com.mokona.element;

import com.mokona.core.MokonaElement;

public class Link extends MokonaElement {

    public String getText() {
        return getElement().getText();
    }

    public void click() {
        getElement().click();
    }

}
