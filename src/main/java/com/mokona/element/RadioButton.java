package com.mokona.element;

import com.mokona.core.MokonaElement;

public class RadioButton extends MokonaElement {

    public void select() {
        getWebElement().click();
    }

    public boolean isSelected() {
        return getWebElement().isSelected();
    }

}
