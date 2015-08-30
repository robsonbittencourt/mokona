package com.mokona.element;

import com.mokona.core.MokonaElement;

public class RadioButton extends MokonaElement {

    public void select() {
        getElement().click();
    }

    public boolean isSelected() {
        return getElement().isSelected();
    }

}
